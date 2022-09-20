package com.gl.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 山毛榉
 * @date : 2022/8/31 18:00
 * @version: 1.0
 * @description: 响应统一处理类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInfo {
    private Integer code;//状态码
    private Boolean success;//成功与否
    private String messages;//响应信息
    private long timeStamp = System.currentTimeMillis();//时间戳
    private String error_info;//错误信息
    private String token;//返回token
    private Object data;//返回体

    //自定义异常返
    public static ResponseInfo difineError(ResponseException e) {

        ResponseInfo result = new ResponseInfo();
        result.setSuccess(false);
        result.setCode(e.getErrorCode());
        result.setMessages(e.getErrorMsg());
        result.setData(null);
        return result;
    }

    public static ResponseInfo otherError(ErrorEnum e) {
        ResponseInfo result = new ResponseInfo();
        result.setMessages(e.getErrorMsg());
        result.setCode(e.getErrorCode());
        result.setData(null);
        result.setSuccess(false);

        return result;
    }


}
