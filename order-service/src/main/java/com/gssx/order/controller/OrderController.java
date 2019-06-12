package com.gssx.order.controller;

import com.gssx.order.dao.OrderDao;
import com.gssx.order.dto.OrderDTO;
import com.gssx.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PutMapping
    public ResponseEntity<?> insert(@RequestBody OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

}
