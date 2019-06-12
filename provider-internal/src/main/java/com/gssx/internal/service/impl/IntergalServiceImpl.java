package com.gssx.internal.service.impl;

import com.gssx.internal.dao.InternalDao;
import com.gssx.internal.service.InternalService;
import com.gssx.internal.vo.Internal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 积分业务层
 * @author 浅陌兮
 */
@Service
@Transactional
public class IntergalServiceImpl implements InternalService {
    @Autowired
    private InternalDao internalDao;
    @Override
    public Internal getByUserId(Integer userId) {
        return internalDao.getByUserId(userId);
    }
}
