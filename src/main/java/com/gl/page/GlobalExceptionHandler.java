package com.gl.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @author: 山毛榉
 * @date : 2022/9/3 20:46
 * @version: 1.0
 * @description:全局异常处理
 */
public class GlobalExceptionHandler{

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = ResponseException.class)
    public ResponseInfo  ResExceptionHandeler(ResponseException e){

        log.error(e.getMessage(),e);
        return  ResponseInfo.difineError(e);

    }
    @ExceptionHandler(value = Exception.class)

    public  ResponseInfo exceptionHandler(Exception e){
        log.error(e.getMessage(),e);
        return  ResponseInfo.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);





    }
}
