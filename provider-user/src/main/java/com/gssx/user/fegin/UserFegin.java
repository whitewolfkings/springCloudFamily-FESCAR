package com.gssx.user.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 服务调用层
 * @author 浅陌兮
 */
@FeignClient(value = "provider-integral",fallback = com.gssx.user.fallback.UserlFallback.class)
public interface UserFegin {
    @CrossOrigin
    @RequestMapping("/getByUserId")
    Map getByUserId(@RequestParam("userId") Integer userId);
}
