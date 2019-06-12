package com.gssx.internal.fegin;

import com.gssx.internal.fallback.InternalFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider-user",fallback = InternalFallback.class)
public interface InternalFegin {
    @RequestMapping("/test")
    String test(@RequestParam("token") String token);
}
