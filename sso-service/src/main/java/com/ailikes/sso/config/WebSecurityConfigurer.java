package com.ailikes.sso.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@Configuration
@Order(2)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(WebSecurityConfigurer.class);

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                // 禁用 CSRF 跨站伪造请求，便于测试
                 csrf().disable()
                // 验证所有请求
                .authorizeRequests().anyRequest().authenticated()
                //允许访问首页
                .antMatchers("/","/login").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public OAuth2RestOperations restOperations(
            OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
        return new OAuth2RestTemplate(resource, context);
    }
}