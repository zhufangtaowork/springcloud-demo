package com.xz.mapper;

import com.xz.po.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName： OrderMapper
 * @Description： TODO
 * @Date： 2022/7/29 下午5:41
 * @author： ZhuFangTao
 */
@Repository
@Mapper
public interface OrderMapper {
    Order byOrderIdGetOrderInfo(@Param(value = "id") Integer id);
}
