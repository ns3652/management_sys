package com.wyh.background_management.controller;

import com.alibaba.fastjson.JSONObject;
import com.wyh.background_management.service.RegisterService;
import com.wyh.background_management.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RegisterService registerService;

    @PostMapping("/addUser")
    public JSONObject register(String username, String password){
        registerService.registerNewUser(username, password);
        return JsonUtil.toJSONObject(true, "200", "新增用户成功", "");
    }
}
