package com.its.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //인터페이스에 대한 군현
public class WebConfig implements WebMvcConfigurer{
    private  String connectPath = "/upload/**";
    private  String resourcePath = "file:///D:/spring_img/";
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(connectPath)
                .addResourceLocations(resourcePath);
    }
}
