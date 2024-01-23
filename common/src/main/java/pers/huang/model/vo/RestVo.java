package pers.huang.model.vo;

import lombok.Data;
import pers.huang.enums.ResultCodeEnum;

import java.io.Serializable;

/**
 * @Author: HuangRenjie
 * @Date: 2023/1/23 22:51
 * @Description:
 */
@Data
public class RestVo<T> implements Serializable {

    private String code;

    private String message;

    private T data;

    public RestVo() {
    }

    public RestVo(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static RestVo failedVo() {
        return failedVo(ResultCodeEnum.FAILED.msg());
    }

    public static RestVo failedVo(String message) {
        return new RestVo(ResultCodeEnum.FAILED.code(), message, null);
    }

    public static <T> RestVo failedVo(String message, T data) {
        return new RestVo(ResultCodeEnum.FAILED.code(), message, data);
    }

    public static RestVo failedVo(String code, String message) {
        return new RestVo(code, message, null);
    }

    public static <T> RestVo failedVo(String code, String message, T data) {
        return new RestVo(code, message, data);
    }

    public static RestVo failedVo(ResultCodeEnum codeEnum) {
        return new RestVo(codeEnum.code(), codeEnum.msg(), null);
    }

    public static <T> RestVo failedVo(ResultCodeEnum codeEnum, T data) {
        return new RestVo(codeEnum.code(), codeEnum.msg(), data);
    }

    public static RestVo successVo() {
        return successVo(null);
    }

    public static <T> RestVo successVo(T data) {
        return new RestVo(ResultCodeEnum.SUCCESS.code(), ResultCodeEnum.SUCCESS.msg(), data);
    }

}
