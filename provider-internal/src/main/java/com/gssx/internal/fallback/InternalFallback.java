package com.gssx.internal.fallback;

import com.gssx.internal.fegin.InternalFegin;
import org.springframework.stereotype.Component;

/**
 * 积分服务断路器
 * @author 浅陌兮
 */
@Component
public class InternalFallback implements InternalFegin {
    @Override
    public String test(String token) {
        return "熔断器启动进行降级";
    }
}
