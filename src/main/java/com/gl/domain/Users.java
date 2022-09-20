package com.gl.domain;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA
 package com.zc.domain;


 import java.io.Serializable;

 /**
 * Created by IntelliJ IDEA
 *
 * @author: 山毛榉
 * @date : 2022/9/1 09:45
 * @version: 1.0
 * Description: users:对应数据库登录用户名和密码
 */

public class Users  implements Serializable {
        private String   id;
        private  String name;
        private String ps;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPs() {
                return ps;
        }

        public void setPs(String ps) {
                this.ps = ps;
        }

        public Users(String id, String name, String ps) {
                this.id = id;
                this.name = name;
                this.ps = ps;
        }

        public Users() {
        }

        @Override
        public String toString() {
                return "Users{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", ps='" + ps + '\'' +
                        '}';
        }
}
