package com.gssx.order.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderDao {
    /**
     * 创建订单
     * @param userId
     * @param commodityCode
     * @param count
     * @param money
     */
    @Update("insert into order_tbl value(null,#{userId},#{commodityCode},#{count},#{money})")
    void createOrder(@Param("userId") String userId,
                     @Param("commodityCode") String commodityCode,
                     @Param("count") Integer count,
                     @Param("money") Integer money);

}
