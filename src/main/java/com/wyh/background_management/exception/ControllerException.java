package com.wyh.background_management.exception;

/**
 * @program: manager
 * @description:
 * @author: wuyinhao
 * @create:2019-12-29-15:49
 **/

import com.alibaba.fastjson.JSONObject;
import com.wyh.background_management.exception.base.BaseDefineException;
import com.wyh.background_management.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ControllerException implements ErrorController {
    private final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public JSONObject handlerError(HttpServletRequest request){
        Map<String, Object> attributesMap = getErrorAttributes(request, true);
        String code = attributesMap.get("status").toString();
        String message = attributesMap.get("message").toString();

        return JsonUtil.toJSONObject(false, code, message, "");
    }

    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace){
        Map<String, Object> errMap = new HashMap<>();
        WebRequest webRequest = new ServletWebRequest(request);

        BaseDefineException baseDefineException = null;
        if (this.errorAttributes.getError(webRequest) instanceof BaseDefineException){
            baseDefineException = (BaseDefineException) this.errorAttributes.getError(webRequest);
        }

        if (baseDefineException != null){
            errMap.put("status", baseDefineException.errorCode);
            errMap.put("message", baseDefineException.msg);
            return errMap;
        }else{
            return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
        }
    }
}
