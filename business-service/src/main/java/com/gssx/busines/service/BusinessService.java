package com.gssx.busines.service;

import com.gssx.busines.dto.BusinessDTO;

public interface BusinessService {
    /**
     * 下单
     * @param businessDTO
     */
    void purchase(BusinessDTO businessDTO);
}
