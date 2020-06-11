package com.wyh.background_management.config;

import com.alibaba.fastjson.JSONObject;
import com.wyh.background_management.utils.JsonUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        Integer code = HttpServletResponse.SC_UNAUTHORIZED;
        response.getWriter().print(JsonUtil.toJSONObject(false, code.toString(), "Unauthorized", ""));
        response.setStatus(code);
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}


