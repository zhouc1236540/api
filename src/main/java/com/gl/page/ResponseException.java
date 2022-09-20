package com.gl.page;


/**
 * @author: 山毛榉
 * @date : 2022/9/3 20:28
 * @version: 1.0
 * @description:none
 */

public class ResponseException  extends  RuntimeException{
    protected  Integer errorCode;
    protected  String  errorMsg;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ResponseException(){};
    public ResponseException(Integer errorCode, String errorMsg) {
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
