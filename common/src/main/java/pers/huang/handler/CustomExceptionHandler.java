package pers.huang.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.huang.enums.ResultCodeEnum;
import pers.huang.model.vo.RestVo;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = CustomException.class)
    public RestVo handleSimpleException(CustomException e){
        e.printStackTrace();
        return RestVo.failedVo(e.code,e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public RestVo handleException(Exception e){
        e.printStackTrace();
        return RestVo.failedVo(ResultCodeEnum.FAILED);
    }
}
