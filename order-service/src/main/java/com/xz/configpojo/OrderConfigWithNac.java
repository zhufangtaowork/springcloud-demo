package com.xz.configpojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName： OrderConfigWithNac
 * @Description： 接收nacos配置管理的配置属性
 * @Date： 2022/8/1 下午4:55
 * @author： ZhuFangTao
 */
@EnableConfigurationProperties({OrderConfigWithNac.class})
@ConfigurationProperties(prefix = "order-config")
@Data
@Component
public class OrderConfigWithNac {
    private String dateFormat;
}
