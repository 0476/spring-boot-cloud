package com.ailikes.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能描述:单点登录回调地址
 *
 * @author 徐大伟
 * @version 1.0.0
 * @date 19-6-12 19:17
 */
@Controller
@RequestMapping
public class OAuth2CallbackController {

    private static Logger logger = LoggerFactory.getLogger(OAuth2CallbackController.class);


    @RequestMapping("callback")
    public String callback(String code){
        logger.error("回调code：{}",code);
        return "index";
    }
}
