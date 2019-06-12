package com.gssx.account.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountDao {
    /**
     * 账户余额更新
     * @param   userId
     * @param   money
     * @return  money
     */
    @Update("update account_tbl set money = money - #{money} where user_id = #{userId} and money > #{money}")
    int updateAccount(@Param("userId")String userId, @Param("money") Integer money);
}
