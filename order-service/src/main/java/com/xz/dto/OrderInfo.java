package com.xz.dto;

import com.xz.po.Order;
import com.xz.po.User;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName： OrderInfo
 * @Description： 订单信息DTO
 * @Date： 2022/7/29 下午5:39
 * @author： ZhuFangTao
 */
@Data
public class OrderInfo extends Order {
    private User user;
    private String getTime;
}
