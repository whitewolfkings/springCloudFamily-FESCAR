package com.gssx.user.service;

import com.gssx.user.vo.User;

public interface UserService {
    void saveUser(User user);
    Integer login(String userName,String password);
}
