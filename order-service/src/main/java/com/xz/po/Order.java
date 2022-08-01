package com.xz.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

/**
 * @ClassName： Order
 * @Description： TODO
 * @Date： 2022/7/29 下午4:04
 * @author： ZhuFangTao
 */
@Alias(value = "order")
@Data
public class Order {

    private Integer id;
    private Integer userId;
    private String productDetail;
    private BigDecimal price;
    private Integer num;
}
