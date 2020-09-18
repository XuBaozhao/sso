package com.bupt.ssoclienttaobao.configuration;

        import com.bupt.ssoclienttaobao.interceptor.TaobaoInterceptor;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] addPathPattrens = {"/taobao"};
        registry.addInterceptor(new TaobaoInterceptor()).addPathPatterns(addPathPattrens);
    }
}