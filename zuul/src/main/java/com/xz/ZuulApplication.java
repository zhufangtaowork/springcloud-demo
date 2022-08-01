package com.xz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName： ZuulApplication
 * @Description： TODO
 * @Date： 2022/7/24 下午1:12
 * @author： ZhuFangTao
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
