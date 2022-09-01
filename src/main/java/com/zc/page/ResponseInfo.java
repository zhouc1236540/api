package com.zc.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 山毛榉
 * @date : 2022/8/31 18:00
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInfo<T> {
    private  Integer code;//状态码
    private Boolean success;//成功与否
    private String messages;//响应信息
    private  long timeStamp =System.currentTimeMillis();//时间戳
    private String error_info;
    private String token;
    private T data;//返回体


}
