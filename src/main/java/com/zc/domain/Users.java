package com.zc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA
 *
 * @author: 山毛榉
 * @date : 2022/7/5 15:45
 * @version: 1.0
 * Description: users
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
        private Integer user_id;
        private  String user_name;
        private String user_password;
        private String user_email;


}
