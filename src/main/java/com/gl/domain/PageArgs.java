package com.gl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 山毛榉
 * @date : 2022/9/1 19:13
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageArgs {
    private Integer pageNum;
    private Integer pageSize;
    private String  ksmc;
}
