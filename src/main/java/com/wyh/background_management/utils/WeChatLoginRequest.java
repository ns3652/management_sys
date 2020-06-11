package com.wyh.background_management.utils;

public class WeChatLoginRequest {
    private String jscode;
    private String nickName;
    private String avatarUrl;
    private int gender;
    private String language;
    private String country;
    private String province;
    private String city;

    public WeChatLoginRequest(String jscode, String nickName, String avatarUrl, int gender, String language, String country, String province, String city) {
        this.jscode = jscode;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.gender = gender;
        this.language = language;
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public String getJscode() {
        return jscode;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public int getGender() {
        return gender;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }
}
