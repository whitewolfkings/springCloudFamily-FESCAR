package com.gssx.internal.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 积分实体类
 * @author 浅陌兮
 */
@Data
public class Internal {
    private Integer inId;
    private Integer userId;
    private BigDecimal balance;
}
