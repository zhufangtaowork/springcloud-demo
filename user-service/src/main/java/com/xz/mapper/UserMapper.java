package com.xz.mapper;


import com.xz.entity.user.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName： UserMapper
 * @Description： TODO
 * @Date： 2022/7/29 下午4:39
 * @author： ZhuFangTao
 */
@Repository
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
}
