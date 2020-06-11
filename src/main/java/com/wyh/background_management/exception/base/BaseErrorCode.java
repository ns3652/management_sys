package com.wyh.background_management.exception.base;

public enum BaseErrorCode implements BaseExceptionEnums {
    WECHAT_LOGIN_SERVER_EXCEPTION(1, "微信登录时服务器内部错误"),
    USER_IS_EXIST_EXCEPTION(2, "新增用户失败，该用户已被注册"),
    THIRD_PARTY_NOT_BIND_USER(3, "第三方用户未绑定本地账号");

    private String description;
    private int code;

    BaseErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
