package com.wyh.background_management.utils;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class MessageUtil {

    //通过中国网建平台向指定手机发送短信验证码
    public static String sendMessage(String phone, String msg, String key, String Uid) throws Exception{
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
        post.addRequestHeader("Content-Type",
                "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
        NameValuePair[] data = { new NameValuePair("Uid", Uid),//中国网建sms平台注册的用户名
                new NameValuePair("Key", key),//中国网建sms平台注册的用户密钥
                new NameValuePair("smsMob", phone),//将要发送到的手机号码
                new NameValuePair("smsText",  msg) };//要发送的短信内容
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        for (Header h : headers) {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes(
                "gbk"));
        System.out.println(result); // 打印返回消息状态

        post.releaseConnection();
        return result;
    }
}
