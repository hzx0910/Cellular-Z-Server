package com.cellular.z.server.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC配置，用于添加springMVC相关设置
 * 暂时没有自定义配置
 *
 * @Author: MaiShengMing
 * @Date: 2022-03-23 00:55
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

}
