package org.tintin.interceptorexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.tintin.interceptorexample.interceptors.BasicAuthInterceptor;
import org.tintin.interceptorexample.interceptors.LogHandlerInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHandlerInterceptor()).order(1);
        registry.addInterceptor(new BasicAuthInterceptor())
                .addPathPatterns("/products/new");
    }
}
