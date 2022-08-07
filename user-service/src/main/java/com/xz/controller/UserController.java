package com.xz.controller;

import com.xz.entity.commonview.ResultView;
import com.xz.entity.user.dto.UserInfo;
import com.xz.entity.user.po.User;
import com.xz.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

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
    public ResultView<UserInfo> getUserInfo(@PathVariable(value = "id",required = false) Integer id){
        return userService.byUserIdGetUserInfo(id);
    }

    @PutMapping("/add")
    public ResultView addUserInfo(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping(value = "/login")
    public ResultView login(@RequestParam String username, @RequestParam String password) {
        return userService.loginByUsernameAndPassword(username,password);

    }


}
