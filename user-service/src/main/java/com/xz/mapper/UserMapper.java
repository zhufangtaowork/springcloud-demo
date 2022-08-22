package com.xz.mapper;


import com.alibaba.fastjson.JSONObject;
import com.xz.entity.user.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName： UserMapper
 * @Description： TODO
 * @Date： 2022/7/29 下午4:39
 * @author： ZhuFangTao
 */

@Mapper
public interface UserMapper {
    /**
     * 功能描述: <br>
     * 〈根据用户ID查询用户信息〉
     * @Param: [id]
     * @Return: com.xz.dto.UserInfo
     * @Author: zft
     * @Date: 2022/7/29 下午4:43
     */
    User byUserIdGetUserInfo(@Param(value = "id") Integer id);

    /**
     * 功能描述: <br>
     * 〈添加用户〉
     * @Param: [user]
     * @Return: java.lang.Integer
     * @Author: zft
     * @Date: 2022/8/6 下午6:29
     */
    Integer addUser(User user);


    /**
     * 功能描述: <br>
     * 〈根据用户名查找用户〉
     * @Param: [username]
     * @Return: com.xz.entity.user.po.User
     * @Author: zft
     * @Date: 2022/8/7 下午4:13
     */
    User getUserByUsername(String username);

    /**
     * 功能描述: <br>
     * 〈查询用户〉
     * @Param: [jsonParams]
     * @Return: java.util.List<com.xz.entity.user.po.User>
     * @Author: zft
     * @Date: 2022/8/21 下午3:12
     */
    List<User> getUserList(JSONObject jsonParams);
}
