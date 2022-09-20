package com.gl.domain.TO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 山毛榉
 * @date : 2022/9/9 14:22
 * @version: 1.0
 * @description:none
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryCondition {
    private String field;//字段属性
    private String compareSymbol; //比较符
    private String value; //参数值
    private String linkSymbol;//连接符or and
}
