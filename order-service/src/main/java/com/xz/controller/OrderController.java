package com.xz.controller;

import com.xz.entity.commonview.ResultView;
import com.xz.entity.order.dto.OrderInfo;
import com.xz.entity.order.po.Order;
import com.xz.service.OrderService;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping(value = "/add")
    public ResultView addOrderInfo(@RequestBody Order order){
        return orderService.addOrderInfo(order);
    }
}
