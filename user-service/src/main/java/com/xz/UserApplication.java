package com.xz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName： UserApplication
 * @Description： TODO
 * @Date： 2022/7/24 下午12:59
 * @author： ZhuFangTao
 */
@EnableFeignClients
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
