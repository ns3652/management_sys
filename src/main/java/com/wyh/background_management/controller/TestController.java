package com.wyh.background_management.controller;

import com.alibaba.fastjson.JSONObject;
import com.wyh.background_management.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: manager
 * @description:
 * @author: wuyinhao
 * @create:2019-12-29-15:50
 **/
@RestController
@CrossOrigin(allowCredentials = "true")
public class TestController {
    @GetMapping("/test")
    @PreAuthorize("hasAuthority('user_query')")
    public JSONObject hello(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println(authentication.getAuthorities());
        return JsonUtil.toJSONObject(true, "200", "", "hello," + name);
    }

    @GetMapping("/testAuth")
    @PreAuthorize("hasAuthority('admin_query')")
    public JSONObject helloAuth(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println(authentication.getAuthorities());
        return JsonUtil.toJSONObject(true, "200", "", "hello," + name);
    }
}
