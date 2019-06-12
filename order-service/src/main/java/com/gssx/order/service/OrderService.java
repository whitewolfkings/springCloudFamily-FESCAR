package com.gssx.order.service;

import com.gssx.order.dto.OrderDTO;

public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     */
    void createOrder(OrderDTO orderDTO);
}
