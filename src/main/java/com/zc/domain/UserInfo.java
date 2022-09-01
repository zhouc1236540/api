package com.zc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 山毛榉
 * @date : 2022/8/30 18:49
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo<T> {

    private  Integer code;//状态码
    private Boolean success;//成功与否
    private String messages;//响应信息
    private T userInfo;//返回体
    private String token;
    private  long timeStamp =System.currentTimeMillis();//时间戳

}
