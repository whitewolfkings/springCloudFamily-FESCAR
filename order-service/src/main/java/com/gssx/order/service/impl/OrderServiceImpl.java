package com.gssx.order.service.impl;

import com.gssx.order.dao.OrderDao;
import com.gssx.order.dto.AccountDTO;
import com.gssx.order.dto.OrderDTO;
import com.gssx.order.service.AccountService;
import com.gssx.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccountService accountService;
    /**
     * 创建订单
     *
     * @param orderDTO
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void createOrder(OrderDTO orderDTO) {
        String userId = orderDTO.getUserId();
        String commodityCode = orderDTO.getCommodityCode();
        Integer count = orderDTO.getCount();
        Assert.notNull(orderDTO, "orderDTO");
        Assert.notNull(userId, "userId");
        Assert.notNull(commodityCode, "commodityCode");
        Assert.notNull(count, "count");
        Integer money = count * 200;

        orderDao.createOrder(userId, commodityCode, count, money);
        if(new Random().nextInt(10) == 1){
            throw new RuntimeException("unknown error");
        }

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setMoney(money);
        accountDTO.setUserId(userId);
        accountService.updateAccount(accountDTO);
    }
}
