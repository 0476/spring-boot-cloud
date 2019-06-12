package com.ailikes.auth;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
@ComponentScan({"com.ailikes.base", "com.ailikes.auth", "com.ailikes.jjzx"})
@MapperScan("com.ailikes.jjzx.mapper")
@RestController
public class AuthApplication {
    private static final Logger logger = LoggerFactory.getLogger(AuthApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    // 添加一个测试访问接口
    @GetMapping("/user")
    public Authentication getUser(Authentication authentication) {
        logger.info("resource: user {}", authentication);
        return authentication;
    }
}
