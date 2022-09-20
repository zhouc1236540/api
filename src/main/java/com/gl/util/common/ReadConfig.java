package com.gl.util.common;

import org.junit.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author: 山毛榉
 * @date : 2022/9/9 19:01
 * @version: 1.0
 * @description:none
 */
public class ReadConfig {

    @Test
    public void readConfig() throws IOException {
        /*读取配置*/
        Properties config = new Properties();

        String path = System.getProperty("user.dir");
        String file=path+"/src/main/resources/application.properties";

        config.load(new FileReader(file));
        String userName = config.getProperty("spring.datasource.username");
        String password = config.getProperty("spring.datasource.password");
        String url = config.getProperty("spring.datasource.url");

        System.out.println("url="+url   + "username="+
                userName  +"password="
                + password);
        System.out.println("----------------------------------");


    }


    @Test
    public  void updateProperties() throws IOException {
        Properties properties = new Properties();
        String path = System.getProperty("user.dir");
        String filePaht=path+"/src/main/resources/application.properties";
        properties.setProperty("spring.datasource.username","tiger");
        properties.store(new FileOutputStream(filePaht),"注释");






    }

    @Test
    public void config() {
        ResourceBundle bundle = ResourceBundle.getBundle("application");
        System.out.println("----" + bundle.getLocale());
        String name = bundle.getString("spring.datasource.username");
        String password = bundle.getString("spring.datasource.password");
        String url = bundle.getString("spring.datasource.url");

        System.out.println(name + password + url
        );


    }
    @Test
    public void getPath(){



    }

}
