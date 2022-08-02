package com.xz;

import com.xz.feignloggerconfig.FeignLoggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName： OrderApplication
 * @Description： TODO
 * @Date： 2022/7/29 下午4:02
 * @author： ZhuFangTao
 */
@EnableFeignClients(defaultConfiguration = FeignLoggerConfig.class)
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);

    }
}
