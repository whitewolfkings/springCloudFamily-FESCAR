package com.gssx.internal.dao;

import com.gssx.internal.vo.Internal;
import org.apache.ibatis.annotations.Mapper;

/**
 * 积分数据持久层
 * @author 浅陌兮
 */
@Mapper
public interface InternalDao {
    Internal getByUserId(Integer userId);

}
