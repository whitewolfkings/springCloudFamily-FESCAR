package com.gssx.internal.controller;

import com.gssx.internal.fegin.InternalFegin;
import com.gssx.internal.service.InternalService;
import com.gssx.internal.vo.Internal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class InternalController {
    @Autowired
    private InternalFegin internalFegin;
    @Autowired
    private InternalService internalService;
    @RequestMapping("/renoteuser")
    public String test(@RequestParam("token") String token){
        return internalFegin.test(token);
    }
    @CrossOrigin
    @RequestMapping("/getByUserId")
    public Map getByUserId(@RequestParam("userId") Integer userId){
        Map map = new HashMap();
        Internal internal  = internalService.getByUserId(userId);
        map.put("code",200);
        map.put("message","访问成功");
        map.put("data",internal);
        return map;
    }
//    @RequestMapping("/updateConfig")
//    public Map updateConfig(){
//        Map map = new HashMap();
//        map.put("username",jdbcConfig.getUsername());
//        map.put("password",jdbcConfig.getPassword());
//        return map;
//    }
}
