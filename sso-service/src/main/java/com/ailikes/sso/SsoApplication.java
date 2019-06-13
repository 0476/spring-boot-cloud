package com.ailikes.sso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.request.RequestContextListener;

@EnableOAuth2Sso
@SpringBootApplication
@ComponentScan({"com.ailikes.base","com.ailikes.sso"})
public class SsoApplication extends SpringBootServletInitializer {
    private static final Logger log = LoggerFactory.getLogger(SsoApplication.class);

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(SsoApplication.class).run(args);
    }

}