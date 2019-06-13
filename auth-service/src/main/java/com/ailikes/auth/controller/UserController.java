package com.ailikes.auth.controller;

import com.ailikes.auth.AuthApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(AuthApplication.class);
    @GetMapping(value = "/user")
    public Principal getUser(Principal principal) {
        return principal;
    }

    // 添加一个测试访问接口
    @GetMapping("/userAuthentication")
    public Authentication userAuthentication(Authentication authentication) {
        logger.info("userAuthentication {}", authentication);
        return authentication;
    }
}
