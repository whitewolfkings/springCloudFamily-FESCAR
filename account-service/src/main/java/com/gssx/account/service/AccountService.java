package com.gssx.account.service;

import com.gssx.account.dto.AccountDTO;

public interface AccountService {
    /**
     * 账户余额更新
     * @param accountDTO
     */
    void updateAccount(AccountDTO accountDTO);
}
