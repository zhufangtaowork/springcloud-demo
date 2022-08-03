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
}
