package com.gssx.storage.service;

import com.gssx.storage.dto.StorageDTO;

public interface StorageService {
    /**
     * 更新库存
     * @param storageDTO
     */
    void updateStorage(StorageDTO storageDTO);
}
