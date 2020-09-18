package com.bupt.ssoclienttmall.configuration;

import com.bupt.ssoclienttmall.interceptor.TmallInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] addPathPattrens = {"/tmall"};
        registry.addInterceptor(new TmallInterceptor()).addPathPatterns(addPathPattrens);
    }
}