package com.wyh.background_management.pojo;


import java.util.Date;

/**
 *
 * 第三方授权的用户信息
 *
 * */
public class SysUserAuths {
    private Integer id;

    private Integer userId;                    //关联到本平台的用户id

    private int identityType;            //登录类型(QQ、weChat、email)

    private String identityDisplay;           //登录描述

    private String identifier;              //第三方应用的唯一标识(例如微博Uid，QQunionID，微信openID)

    private String credential;          //密码凭证  站内保存密码，站外不保存或者只保存token

    private String authImg;            //第三方头像url

    private String nickname;            //第三方昵称

    private int gender;              //第三方用户性别

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public int getIdentityType() {
        return identityType;
    }

    public String getIdentityDisplay() {
        return identityDisplay;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getCredential() {
        return credential;
    }

    public String getAuthImg() {
        return authImg;
    }

    public String getNickname() {
        return nickname;
    }

    public int getGender() {
        return gender;
    }
}
