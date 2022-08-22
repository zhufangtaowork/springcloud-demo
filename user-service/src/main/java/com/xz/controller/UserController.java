package com.xz.controller;


import com.alibaba.fastjson.JSONObject;
import com.xz.entity.commonview.ResultPageView;
import com.xz.entity.commonview.ResultView;
import com.xz.entity.user.dto.UserInfo;
import com.xz.entity.user.po.User;
import com.xz.service.UserService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName： UserController
 * @Description： TODO
 * @Date： 2022/7/29 下午4:08
 * @author： ZhuFangTao
 */

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final static Integer DEFAULT_PAGE = 1;
    private final static String DEFAULT_PAGE_NAME = "page";
    private final static Integer DEFAULT_PAGE_SIZE = 5;
    private final static String DEFAULT_PAGE_SIZE_NAME = "pageSize";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 功能描述: <br>
     * 〈用户登录〉
     * @Param: [username, password]
     * @Return: com.xz.entity.commonview.ResultView
     * @Author: zft
     * @Date: 2022/8/22 下午3:08
     */
    @PostMapping(value = "/login")
    public ResultView login(@RequestParam String username, @RequestParam String password) {
        return userService.loginByUsernameAndPassword(username,password);
    }

    /**
     * 功能描述: <br>
     * 〈用户添加〉
     * @Param: [user]
     * @Return: com.xz.entity.commonview.ResultView
     * @Author: zft
     * @Date: 2022/8/22 下午3:08
     */
    @PutMapping("/add")
    public ResultView addUserInfo(@RequestBody User user){
        return userService.addUser(user);
    }

    /**
     * 功能描述: <查询用户或列表>
     * 〈id:1,page:1,pageSize:5,order:1(按照人名排序)，sort:1降序，2生序〉〉
     * @Param: [params]
     * @Return: com.xz.entity.commonview.ResultPageView
     * @Author: zft
     * @Date: 2022/8/22 下午3:07
     */
    @PostMapping(value = "/list")
    public ResultPageView<List<UserInfo>> getUserList(@RequestBody HashMap<String,Object> params) {
        if (MapUtils.isEmpty(params) || (params.get(DEFAULT_PAGE_NAME)==null || params.get(DEFAULT_PAGE_SIZE_NAME)==null)){
            params.put("page",DEFAULT_PAGE);
            params.put("pageSize",DEFAULT_PAGE_SIZE);
        }
        JSONObject jsonParams = new JSONObject(params);
        return userService.getUserList(jsonParams);
    }



}
