package com.gssx.user.fallback;
import com.gssx.user.fegin.UserFegin;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务断路器
 * @author 浅陌兮
 */
@Component
public class UserlFallback implements UserFegin {

    @Override
    public Map getByUserId(Integer userId) {
        Map map = new HashMap();
        map.put("code",200);
        map.put("message","熔断器启动进行服务降级");
        map.put("data",-1);
        return map;
    }
}
