package com.xz.service;


import com.xz.entity.commonview.ResultCode;
import com.xz.entity.commonview.ResultView;
import com.xz.entity.user.dto.UserInfo;
import com.xz.entity.user.po.User;
import com.xz.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName： UserService
 * @Description： 用户相关业务处理
 * @Date： 2022/7/29 下午4:29
 * @author： ZhuFangTao
 */
@Service
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 功能描述: <br>
     * 〈根据用户ID查询用户信息Service层方法〉
     * @Param: [id]
     * @Return: com.xz.response.ResultView<com.xz.dto.UserInfo>
     * @Author: zft
     * @Date: 2022/7/29 下午5:02
     */
    public ResultView<UserInfo> byUserIdGetUserInfo(Integer id) {
        UserInfo userInfo = new UserInfo();
        ResultView<UserInfo> resultView = new ResultView<>();
        User user = userMapper.byUserIdGetUserInfo(id);
        if (StringUtils.isEmpty(user)){
            return resultView.setMsgCode(ResultCode.NO_DATA);
        }
        BeanUtils.copyProperties(user,userInfo);
        resultView = resultView.setMsgCode(ResultCode.SUCCESS).setData(userInfo);
        return resultView;
    }

    /**
     * 功能描述: <br>
     * 〈添加用户〉
     * @Param: [user]
     * @Return: com.xz.entity.commonview.ResultView
     * @Author: zft
     * @Date: 2022/8/6 下午6:25
     */
    public ResultView addUser(User user) {
        ResultView resultView = new ResultView<>();
        if (StringUtils.isEmpty(user)) {
            return resultView.setMsgCode(ResultCode.REQUIRED_PARAMETER_MISSING);
        }
        if (!StringUtils.isEmpty(user.getPassword())){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encode = passwordEncoder.encode(user.getPassword());
            user.setPassword(encode);
        }
        User mapperUserByUsername = userMapper.getUserByUsername(user.getUsername());
        if (!StringUtils.isEmpty(mapperUserByUsername)){
            return resultView.setMsgCode(ResultCode.USERNAME_REPEAT);
        }
        Integer res = userMapper.addUser(user);
        if (res!=0){
            return resultView.setMsgCode(ResultCode.SUCCESS);
        }
        return resultView.setMsgCode(ResultCode.FAIL);
    }

    public ResultView loginByUsernameAndPassword(String username, String password) {
        ResultView<Object> resultView = new ResultView<>();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return resultView.setMsgCode(ResultCode.REQUIRED_PARAMETER_MISSING);
        }
        User user = userMapper.getUserByUsername(username);
        if (StringUtils.isEmpty(user)){
            return resultView.setMsgCode(ResultCode.NO_DATA);
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(password, user.getPassword())){
            return resultView.setMsgCode(ResultCode.VALID_PASSWORD);
        }

        return resultView.setMsgCode(ResultCode.SUCCESS);

    }
}
