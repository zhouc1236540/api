package com.gl.util.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 山毛榉
 * @date : 2022/9/9 16:24
 * @version: 1.0
 * @description:none
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer age;
    private String sex;
    private String name;
}
