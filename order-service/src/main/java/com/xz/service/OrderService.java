package com.xz.service;

import com.xz.clients.userclients.UserClients;
import com.xz.configpojo.OrderConfigWithNac;
import com.xz.entity.commonview.ResultCode;
import com.xz.entity.commonview.ResultView;
import com.xz.entity.order.dto.OrderInfo;
import com.xz.entity.order.po.Order;
import com.xz.entity.user.dto.UserInfo;
import com.xz.mapper.OrderMapper;
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
    private OrderConfigWithNac orderConfigWithNac;

    public OrderService(OrderMapper orderMapper, UserClients userClients, OrderConfigWithNac orderConfigWithNac) {
        this.orderMapper = orderMapper;
        this.userClients = userClients;
        this.orderConfigWithNac = orderConfigWithNac;
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
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern(orderConfigWithNac.getDateFormat()));
        orderInfo.setGetTime(format);
        return orderInfoResultView.setMsgCode(ResultCode.SUCCESS).setData(orderInfo);
    }
}
