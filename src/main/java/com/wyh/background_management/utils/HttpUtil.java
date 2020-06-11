package com.wyh.background_management.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.util.Scanner;

public class HttpUtil {
    public static JSONObject sendGet(String url) throws IOException {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);

        try {
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("获取SendGet失败:" + method.getStatusLine());
            }
            JSONObject resObject = JSONObject.parseObject(method.getResponseBodyAsString());
            return resObject;
        }  finally {
            method.releaseConnection();
        }
    }


    public static void main(String[] args) throws IOException {
        //https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=101776587&state=register&redirect_uri=https%3a%2f%2fwww.wyhweb.com%2findex.html
        String appid = "wx13a0c0f4f6c291e1";
        String secret = "f7ddb30556acec2f0c262059ac39f345";
        String jsCode = "061ENXAA1U7p790ThFBA1bQ5BA1ENXAQ";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=authorization_code";

        JSONObject obj = sendGet(url);

        System.out.println(obj);
        System.out.println(obj.get("openid"));

        //{"openid":"oMSz_40poa68eRYSghW-zN5XARWM","session_key":"uI3W2sO3nzGLuDktREI7DA=="}



    }
}
