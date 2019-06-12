package com.ailikes.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

import javax.sql.DataSource;

/**
 * 功能描述:
 *
 * @author 徐大伟
 * @version 1.0.0
 * @date 19-6-11 19:02
 */
@Configuration
@Order(-20)
public class AuthenticationManagerConfig extends GlobalAuthenticationConfigurerAdapter {

    private static MessageDigestPasswordEncoder md5encoder = new MessageDigestPasswordEncoder("MD5");

    @Autowired
    private DataSource dataSource;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(md5encoder);
    }
}
