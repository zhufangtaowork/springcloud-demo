package com.xz.feignloggerconfig;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName： FeignLoggerConfig
 * @Description： TODO
 * @Date： 2022/8/1 下午7:08
 * @author： ZhuFangTao
 */
public class FeignLoggerConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
