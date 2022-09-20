package com.gl.page;

/**
 * @author: 山毛榉
 * @date : 2022/9/3 20:37
 * @version: 1.0
 * @description:错误枚举
 */
public enum ErrorEnum {
    SUCCESS(200,"成功"),
    NO_PREMISSION(403,"无权限"),
    NO_AUTH(401,"未登录"),
    NOT_FOUND(404,"未找到资源"),
    INTERNAL_SERVER_ERROR(500,"服务请求异常"),

    ;
    private static Integer timeStamp;
    /**
     * 错误代码
     */
    private final Integer  errorCode;
    /**
     * 错误信息
     */
    private final String  errorMsg;

    ErrorEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
