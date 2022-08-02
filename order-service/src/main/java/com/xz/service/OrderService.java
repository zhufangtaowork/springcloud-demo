package com.xz.service;

import com.xz.clients.UserClients;
import com.xz.configpojo.OrderConfigWithNac;
import com.xz.dto.OrderInfo;
import com.xz.dto.UserInfo;
import com.xz.mapper.OrderMapper;
import com.xz.po.Order;
import com.xz.response.ResultCode;
import com.xz.response.ResultView;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName： OrderService
 * @Description： TODO
 * @Date： 2022/7/29 下午5:38
 * @author： ZhuFangTao
 */
@Service
public class OrderService {

    private OrderMapper orderMapper;
    private UserClients userClients;
    public OrderService(OrderMapper orderMapper, UserClients userClients, OrderConfigWithNac orderConfigWithNac) {
        this.orderMapper = orderMapper;
        this.userClients = userClients;
    }
    /**
     * 功能描述: <br>
     * 〈根据商品ID查询商品信息〉
     * @Param: [id]
     * @Return: com.xz.response.ResultView<com.xz.dto.OrderInfo>
     * @Author: zft
     * @Date: 2022/7/29 下午5:53
     */
    public ResultView<OrderInfo> byOrderIdGetOrderInfo(Integer id) {
        OrderInfo orderInfo = new OrderInfo();
        ResultView<OrderInfo> orderInfoResultView = new ResultView<>();
        Order order = orderMapper.byOrderIdGetOrderInfo(id);
        if (StringUtils.isEmpty(order)){
            return orderInfoResultView.setMsgCode(ResultCode.NO_DATA);
        }
        BeanUtils.copyProperties(order,orderInfo);
        ResultView<UserInfo> userInfoResultView = userClients.byUserIdGetUserInfo(orderInfo.getUserId());
        orderInfo.setUser(userInfoResultView.getData());
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern(OrderConfigWithNac.DATE_FORMAT));
        orderInfo.setGetTime(format);
        return orderInfoResultView.setMsgCode(ResultCode.SUCCESS).setData(orderInfo);
    }
}
