package com.xz.controller;

import com.xz.dto.OrderInfo;
import com.xz.response.ResultView;
import com.xz.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName： OrderController
 * @Description： TODO
 * @Date： 2022/7/29 下午5:16
 * @author： ZhuFangTao
 */
@RestController
@RequestMapping(value = "/api/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping(value = "/{id}")
    public ResultView<OrderInfo> getOrderInfo(@PathVariable Integer id){
        return orderService.byOrderIdGetOrderInfo(id);
    }
}
