package com.gl.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: 山毛榉
 * @date : 2022/9/3 23:23
 * @version: 1.0
 * @description:none
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value =BusinessException.class)
    public AjaxResult bizExceptionHandler(BusinessException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.defineError(e);
    }

    /**
     *            处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    public AjaxResult exceptionHandler( Exception e) {
        log.error(e.getMessage(), e);
        return AjaxResult.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);

    }

}
