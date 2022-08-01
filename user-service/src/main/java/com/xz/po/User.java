package com.xz.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * @ClassName： User
 * @Description： TODO
 * @Date： 2022/7/29 下午3:51
 * @author： ZhuFangTao
 */
@Alias("user")
@Data
public class User {
    private Integer id;
    private String username;
    private String address;
}
