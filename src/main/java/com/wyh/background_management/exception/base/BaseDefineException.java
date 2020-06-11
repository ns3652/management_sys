package com.wyh.background_management.exception.base;

public class BaseDefineException extends RuntimeException {
    public Integer errorCode;
    public String msg;

    public BaseDefineException(BaseExceptionEnums errorException) {
        super(errorException.getDescription());
        this.errorCode = errorException.getCode();
        this.msg = errorException.getDescription();
    }

    public Integer getErrorCode(){
        return errorCode;
    }

}
