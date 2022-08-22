package com.xz.globalfilter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @ClassName： AuthorizeFilter
 * @Description： 模拟身份验证全局过滤器
 * @Date： 2022/8/6 上午11:07
 * @author： ZhuFangTao
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered{


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
