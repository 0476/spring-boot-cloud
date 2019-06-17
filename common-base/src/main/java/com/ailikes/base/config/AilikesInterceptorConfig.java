package com.ailikes.base.config;

import com.ailikes.base.interceptor.AilikesWebInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * 功能描述:
 *
 * @author 徐大伟
 * @version 1.0.0
 * @date 19-6-11 17:34
 */
@Configuration
public class AilikesInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private AilikesWebInterceptor ailikesWebInterceptor;

    @Autowired
    private LocaleChangeInterceptor localeChangeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //通用拦截器
        registry.addInterceptor(ailikesWebInterceptor).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");
        registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
    }

}
