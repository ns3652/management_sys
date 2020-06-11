package com.wyh.background_management.enums;

import com.wyh.background_management.enums.base.EnumBase;

public enum ThirdPartyTypeEnum implements EnumBase {
    WECHAT(1, "微信登录");
    private int code;
    private String description;

    ThirdPartyTypeEnum(int code, String description) {
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

    public static ThirdPartyTypeEnum getByName(String name){
        if (name == null || "".equals(name)){return null;}
        ThirdPartyTypeEnum[] enums = values();
        for (ThirdPartyTypeEnum thirdPartyEnum:enums){
            if (thirdPartyEnum.name().equals(name)){
                return thirdPartyEnum;
            }
        }
        return null;
    }

    public static ThirdPartyTypeEnum getByCode(int code){
        ThirdPartyTypeEnum[] enums = values();
        for (ThirdPartyTypeEnum thirdPartyEnum:enums){
            if (thirdPartyEnum.code == code){
                return thirdPartyEnum;
            }
        }
        return null;
    }
}
