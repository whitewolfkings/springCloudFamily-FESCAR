package com.gssx.user.dao;

import com.gssx.user.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户数据库持久层
 */
@Mapper
public interface UserDao {
    void saveUser(User user);
    Integer login(@Param("userName") String userName, @Param("password") String password);
}
