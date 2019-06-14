package com.ailikes.auth.config;

import com.ailikes.auth.service.BaseUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
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
@Order(Ordered.HIGHEST_PRECEDENCE)
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
        web.ignoring().antMatchers("/favicon.ico","/static/**", "/public/**","/","/index");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http    .httpBasic().disable().csrf().disable()
                .authorizeRequests().anyRequest().authenticated()//所有请求必须登陆后访问
//                // basic验证
//                .and().httpBasic()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/index").permitAll()
                .and().formLogin().permitAll();
                //.and().authorizeRequests().antMatchers("/oauth/*").authenticated()
//                .and().addFilterBefore(oauth2ClientAuthenticationProcessingFilter, BasicAuthenticationFilter.class);
//        http.authorizeRequests()
//                .antMatchers("/oauth/**","/login/**", "/logout").permitAll()
//                .anyRequest().authenticated()// 其他地址的访问均需验证权限
//                .and().httpBasic() // basic验证
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .and()
//                .logout().logoutSuccessUrl("/");
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