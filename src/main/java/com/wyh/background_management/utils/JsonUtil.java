package com.wyh.background_management.utils;

/**
 * @program: manager
 * @description:
 * @author: wuyinhao
 * @create:2019-29-15:46
 **/
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
    public static JSONObject toJSONObject(Boolean success, String code, String message, Object data){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", success);
        jsonObject.put("code", code);
        jsonObject.put("message", message);
        jsonObject.put("data", data);
        return jsonObject;
    }
}
