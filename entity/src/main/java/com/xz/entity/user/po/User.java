package com.xz.entity.user.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @ClassName： User
 * @Description： TODO
 * @Date： 2022/7/29 下午3:51
 * @author： ZhuFangTao
 */
@Data
public class User {
    private Integer id;
    private String password;
    private String username;
    private String address;
}
