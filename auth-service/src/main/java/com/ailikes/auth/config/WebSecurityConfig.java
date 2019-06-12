package com.ailikes.auth.config;

import com.ailikes.auth.service.BaseUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    private BaseUserDetailService baseUserDetailService;

    private static MessageDigestPasswordEncoder md5encoder = new MessageDigestPasswordEncoder("MD5");

    @Override
    public void configure(WebSecurity web) throws Exception {
        //不拦截静态文件
        web.ignoring().antMatchers("/static/**", "/public/**","/index");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().formLogin().permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/index")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/index")
                .and().requestMatchers().antMatchers("/oauth/**", "/login/**", "/logout/**")
                .and().authorizeRequests().antMatchers("/oauth/*").authenticated()
                .and().formLogin().permitAll();
    }
    /**
     * 用户验证
     * @param auth
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        try {
            auth.userDetailsService(baseUserDetailService).passwordEncoder(md5encoder);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // 设置userDetailsService
        provider.setUserDetailsService(baseUserDetailService);
        // 禁止隐藏用户未找到异常
        provider.setHideUserNotFoundExceptions(false);
        // 使用BCrypt进行密码的hash
        provider.setPasswordEncoder(md5encoder);
        return provider;
    }

}