package com.gssx.busines.controller;

import com.gssx.busines.dto.BusinessDTO;
import com.gssx.busines.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @PutMapping
    public ResponseEntity<?> insert(@RequestBody BusinessDTO businessDTO){
        businessService.purchase(businessDTO);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
}
