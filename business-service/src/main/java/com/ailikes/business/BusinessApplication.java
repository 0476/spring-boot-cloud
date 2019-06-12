package com.ailikes.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述:
 *
 * @author 徐大伟
 * @version 1.0.0
 * @date 19-6-11 19:07
 */
@SpringBootApplication
@EnableResourceServer
@RestController
public class BusinessApplication {

        private static final Logger log = LoggerFactory.getLogger(BusinessApplication.class);

        public static void main(String[] args) {
            new SpringApplicationBuilder(BusinessApplication.class)
                    .run(args);
        }

        // 添加一个测试访问接口
        @GetMapping("/user")
        public Authentication getUser(Authentication authentication) {
            log.info("resource: user {}", authentication);
            return authentication;
        }
}
