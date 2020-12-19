package com.wyh.background_management.controller;

import com.alibaba.fastjson.JSONObject;
import com.wyh.background_management.service.JwtUserDetailsService;
import com.wyh.background_management.service.ThirdPartyService;
import com.wyh.background_management.utils.JsonUtil;
import com.wyh.background_management.utils.JwtRequest;
import com.wyh.background_management.utils.JwtTokenUtil;
import com.wyh.background_management.utils.WeChatLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/auth")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private ThirdPartyService thirdPartyService;

//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public JSONObject createAuthenticationToken(JwtRequest authenticationRequest) throws Exception {
//
//        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//        final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(authenticationRequest.getUsername());
//
//        final String token = jwtTokenUtil.generateToken(userDetails);
//
//        return JsonUtil.toJSONObject(true, "200", "", ResponseEntity.ok(new JwtResponse(token)));
//    }

    /*
    *
    * 账号密码登录
    *
    * */
    @PostMapping("/login")
    public JSONObject createAuthenticationToken(JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return JsonUtil.toJSONObject(true, "200", "登录成功", "Bearer " + token);
    }

    /*
    *
    * 微信登录
    *
    * */
    @PostMapping("/weChatLogin")
    public JSONObject weChatLogin(String jscode, String nickName, String avatarUrl, int gender, String language, String country, String province, String city) throws Exception {
        return thirdPartyService.weChatLogin(new WeChatLoginRequest(jscode, nickName, avatarUrl, gender, language, country, province, city));
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}