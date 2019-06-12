package com.gssx.storage.controller;

import com.gssx.storage.dto.StorageDTO;
import com.gssx.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/storage")
public class StorageController {
    @Autowired
    private StorageService storageService;
    @PostMapping
    public ResponseEntity<?> update(@RequestBody StorageDTO storageDTO){
        storageService.updateStorage(storageDTO);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
}
