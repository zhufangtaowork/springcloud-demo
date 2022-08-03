package com.xz.entity.order.dto;

import com.xz.entity.order.po.Order;
import com.xz.entity.user.po.User;
import lombok.Data;

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
