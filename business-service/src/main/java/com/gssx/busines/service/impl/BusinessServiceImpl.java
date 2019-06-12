package com.gssx.busines.service.impl;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.gssx.busines.dto.BusinessDTO;
import com.gssx.busines.dto.OrderDTO;
import com.gssx.busines.dto.StorageDTO;
import com.gssx.busines.service.BusinessService;
import com.gssx.busines.service.OrderService;
import com.gssx.busines.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
@Service
public class BusinessServiceImpl implements BusinessService{
    @Autowired
    private OrderService orderService;
    @Autowired
    private StorageService storageService;
    /**
     * 下单
     *
     * @param businessDTO
     */
    @GlobalTransactional(name = "purchase")
    @Override
    public void purchase(BusinessDTO businessDTO) {
            String userId = businessDTO.getUserId();
            String commodityCode = businessDTO.getCommodityCode();
            Integer orderCount = businessDTO.getOrderCount();
            Assert.notNull(businessDTO, "businessDTO");
            Assert.notNull(userId, "userId");
            Assert.notNull(commodityCode, "commodityCode");
            Assert.notNull(orderCount, "orderCount");
            StorageDTO storageDTO  = new StorageDTO();
            storageDTO.setCommodityCode(commodityCode);
            storageDTO.setCount(orderCount);
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setUserId(userId);
            orderDTO.setCommodityCode(commodityCode);
            orderDTO.setCount(orderCount);
            storageService.updateStorage(storageDTO);
            orderService.createOrder(orderDTO);
    }
}
