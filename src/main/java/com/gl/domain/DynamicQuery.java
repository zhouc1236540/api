package com.gl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 山毛榉
 * @date : 2022/9/2 14:49
 * @version: 1.0
 * @description:动态查询传参
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DynamicQuery {
    //字段
    private String field;
    //表名
    private String tableName;
    //查询条件
    private String condition;
}
