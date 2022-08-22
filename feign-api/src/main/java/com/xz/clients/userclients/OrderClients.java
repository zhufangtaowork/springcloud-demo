package com.xz.clients.userclients;

import com.xz.entity.commonview.ResultView;
import com.xz.entity.order.po.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName： OrderClients
 * @Description： TODO
 * @Date： 2022/8/18 下午12:58
 * @author： ZhuFangTao
 */
@FeignClient(value = "order-service")
public interface OrderClients {

    @PutMapping(value = "/api/order/add")
    ResultView addOrderInfo(@RequestBody Order order);
}
