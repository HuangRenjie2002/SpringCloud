package pers.huang.handler;

import pers.huang.enums.ResultCodeEnum;

public class CustomException extends RuntimeException{
    protected String code;
    protected String message;

    public CustomException(){

    }

    public CustomException(ResultCodeEnum codeEnum){
        super(codeEnum.msg());
        this.code = codeEnum.code();
        this.message = codeEnum.msg();
    }

    public CustomException(ResultCodeEnum codeEnum, String msg){
        super(msg);
        this.code = codeEnum.code();
        this.message = msg;
    }
}
