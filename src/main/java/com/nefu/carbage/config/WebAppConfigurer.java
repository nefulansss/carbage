package com.nefu.carbage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: carbage
 * @description:
 * @author: nefulan
 * @create: 2020-03-25 22:47
 **/
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                //.allowedOrigins("http://192.168.89.89")
                //rest集中请求方式
                .allowedMethods("GET", "POST","DELETE")
                .allowCredentials(false).maxAge(3600);
    }
}