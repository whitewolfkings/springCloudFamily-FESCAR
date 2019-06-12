package com.gssx.user.service.impl;

import com.gssx.user.dao.UserDao;
import com.gssx.user.service.UserService;
import com.gssx.user.vo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public Integer login(String userName, String password) {
        return userDao.login(userName, password);
    }
}
