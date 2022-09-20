package com.gl.util.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 山毛榉
 * @date : 2022/9/10 20:50
 * @version: 1.0
 * @description:none
 */
public class Config  implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String name = "applicationConfig: [classpath:/application.properties]";
        MapPropertySource propertySource = (MapPropertySource) environment.getPropertySources().get(name);
        assert propertySource != null;
        Map<String, Object> source = propertySource.getSource();
        Map map = new HashMap();
        source.forEach(map::put);
        // 将配置的端口号修改为 8022
        map.replace("server.port", 8081);
        environment.getPropertySources().replace(name, new MapPropertySource(name, map));



    }
}
