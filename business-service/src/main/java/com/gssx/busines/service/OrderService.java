package com.gssx.busines.service;

import com.gssx.busines.dto.OrderDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "order", url = "http://localhost:11113/order")
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     */
    @RequestMapping(method = RequestMethod.PUT)
    void createOrder(OrderDTO orderDTO);
}
