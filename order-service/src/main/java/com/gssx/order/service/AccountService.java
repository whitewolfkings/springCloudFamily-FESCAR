package com.gssx.order.service;

import com.gssx.order.dto.AccountDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
@FeignClient(name = "account", url = "http://localhost:11111/account")
public interface AccountService {
    /**
     * 账户余额更新
     * @param accountDTO
     */
    @PostMapping
    void updateAccount(AccountDTO accountDTO);

}
