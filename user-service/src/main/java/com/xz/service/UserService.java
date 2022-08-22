package com.xz.service;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.clients.userclients.OrderClients;
import com.xz.entity.commonview.ResultCode;
import com.xz.entity.commonview.ResultPageView;
import com.xz.entity.commonview.ResultView;
import com.xz.entity.user.dto.UserInfo;
import com.xz.entity.user.po.User;
import com.xz.mapper.UserMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName： UserService
 * @Description： 用户相关业务处理
 * @Date： 2022/7/29 下午4:29
 * @author： ZhuFangTao
 */
@Service
public class UserService {

    private MapperFacade mapperFacade;
    private UserMapper userMapper;

    public UserService(UserMapper userMapper, OrderClients orderClients, MapperFacade mapperFacade) {
        this.userMapper = userMapper;
        this.mapperFacade = mapperFacade;
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
        if (res >0){
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

    /**
     * 功能描述: <br>
     * 〈id:1,page:1,pageSize:5,order:1(按照人名排序)，sort:1降序，2生序〉
     * @Param: [jsonParams]
     * @Return: com.xz.entity.page.PageView
     * @Author: zft
     * @Date: 2022/8/21 下午3:12
     * @return
     */
    public ResultPageView<List<UserInfo>> getUserList(JSONObject jsonParams) {
        ResultPageView<List<UserInfo>> pageView = new ResultPageView<>();
        List<UserInfo> userInfoList = new ArrayList<>();
        PageInfo<User> pageInfo = PageHelper.startPage(jsonParams.getInteger("page"), jsonParams.getInteger("pageSize")).doSelectPageInfo(() -> userMapper.getUserList(jsonParams));
        List<User> list = pageInfo.getList();
        if (list.isEmpty()){
            return pageView.setMsgCode(ResultCode.NO_DATA);
        }
        userInfoList=mapperFacade.mapAsList(list,UserInfo.class);
        pageView.
                setData(userInfoList).
                setPageNum(pageInfo.getPageNum()).
                setPageSize(pageInfo.getPageSize()).
                setTotal(pageInfo.getTotal()).
                setMaxPage(pageInfo.getPages()).
                setMsgCode(ResultCode.SUCCESS);
        return pageView;
    }
}
