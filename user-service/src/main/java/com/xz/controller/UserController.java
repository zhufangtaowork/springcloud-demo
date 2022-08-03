package com.xz.controller;

import com.xz.entity.commonview.ResultView;
import com.xz.entity.user.dto.UserInfo;
import com.xz.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName： UserController
 * @Description： TODO
 * @Date： 2022/7/29 下午4:08
 * @author： ZhuFangTao
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResultView<UserInfo> getUserInfo(@PathVariable Integer id){
        return userService.byUserIdGetUserInfo(id);
    }
}
