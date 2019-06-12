package com.gssx.user.vo;

import lombok.Data;

/**
 * 用户实体类
 * @author 浅陌兮
 */
@Data
public class User {
    private Integer userId;
    private String userName;
    private String sex;
    private Integer age;
    private String password;
}
