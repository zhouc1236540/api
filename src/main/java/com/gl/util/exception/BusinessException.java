package com.gl.util.exception;

/**
 * @author: 山毛榉
 * @date : 2022/9/3 23:22
 * @version: 1.0
 * @description:none
 */
public class BusinessException  extends  RuntimeException{

    private static final long serialVersionUID = 1L;
    /**
     * 错误状态码
     */
    protected Integer errorCode;
    /**
     * 错误提示
     */
    protected String errorMsg;

    public BusinessException() {

    }

    public BusinessException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
