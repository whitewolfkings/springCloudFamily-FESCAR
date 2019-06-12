package com.gssx.busines.service;

import com.gssx.busines.dto.StorageDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "storage", url = "http://localhost:11114/storage")
public interface StorageService {
    /**
     * 更新库存
     * @param storageDTO
     */
    @RequestMapping(method = RequestMethod.POST)
    void updateStorage(StorageDTO storageDTO);
}
