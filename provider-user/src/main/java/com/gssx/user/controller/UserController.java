package com.gssx.user.controller;


import com.gssx.user.fegin.UserFegin;
import com.gssx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户的控制器
 */
@RestController
public class UserController {
    @Autowired
    private UserFegin userFegin;
    @Autowired
    private UserService userService;
    @RequestMapping("/test")
    public String test (){
        return "调用用户服务成功";
    }
    @CrossOrigin
    @RequestMapping("/getInternalByUserId")
    public Map getInternalByUserId(@RequestParam("userId") Integer userId){
        return userFegin.getByUserId(userId);
    }
    @CrossOrigin
    @PostMapping(value = "/login")
    public Map login(@RequestParam("userName") String userName,@RequestParam("password") String password){
        Map map = new HashMap();
        Integer l = userService.login(userName,password);
        if(l>0){
            map.put("code",200);
            map.put("message","登录成功");
            return map;
        }else {
            map.put("code",20001);
            map.put("message","您输入的用户名或者密码错误");
            return map;
        }
    }


}
