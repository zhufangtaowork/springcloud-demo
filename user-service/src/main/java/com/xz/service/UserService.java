package com.xz.service;


import com.xz.entity.commonview.ResultCode;
import com.xz.entity.commonview.ResultView;
import com.xz.entity.user.dto.UserInfo;
import com.xz.entity.user.po.User;
import com.xz.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
}
