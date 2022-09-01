package com.zc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 山毛榉
 * @date : 2022/8/31 11:20
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenInfo {
    private boolean flag;
    private String messages;
    private  String tokens;
    private  Long timestamp =System.currentTimeMillis();
}
