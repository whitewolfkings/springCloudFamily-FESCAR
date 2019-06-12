package com.gssx.busines.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;
}
