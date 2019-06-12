package com.gssx.configclient.controller;

import com.gssx.configclient.config.ContentConfig;
import com.gssx.configclient.config.RabbitmqConfig;
import com.gssx.configclient.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope//开启更新功能
@RequestMapping("api")
public class ConfigClientController {
    @Autowired
    private RabbitmqConfig rabbitmqConfig;
    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    private ContentConfig contentConfig;
//    @Value("${from}")
//    private String from;
    /**
     * 返回配置文件的内容
     */
//    @GetMapping("/from")
//    public String from(){
//        return from;
//    }
    @GetMapping("/updateConfig")
    public Map update(){
        Map map = new HashMap();
        map.put("code",200);
//        map.put("username",rabbitmqConfig.getUsername());
        map.put("password",rabbitmqConfig.getPassword());
        map.put("host",rabbitmqConfig.getHost());
        map.put("port", serverConfig.getPort());
        map.put("content",contentConfig.getContent());
        return map;

    }
}
