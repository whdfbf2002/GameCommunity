package com.bitc.springproject.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSizePerFile(10 * 1024 * 1024);

        return commonsMultipartResolver;
    }

//    @Value("C:/temp/spring/img")
//    private String imagesLocation;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        String imgPath = "file:///" + imagesLocation;
//
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations(imgPath);
//
//    }

}
