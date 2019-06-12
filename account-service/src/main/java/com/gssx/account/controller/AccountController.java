package com.gssx.account.controller;

import com.gssx.account.dto.AccountDTO;
import com.gssx.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/account")
public class AccountController {
@Autowired
private AccountService accountService;
    @PostMapping
    public ResponseEntity<?> update(@RequestBody AccountDTO accountDTO){
        accountService.updateAccount(accountDTO);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
}
