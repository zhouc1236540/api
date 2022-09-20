package com.gl.domain.TO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: 山毛榉
 * @date : 2022/9/6 10:26
 * @version: 1.0
 * @description:none
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddtionTable {

    private String tableName;
    private List<Colunms> cloumns;

}
