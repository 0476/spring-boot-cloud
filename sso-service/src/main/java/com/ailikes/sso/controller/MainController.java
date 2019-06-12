package com.ailikes.sso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 功能描述:
 *
 * @author 徐大伟
 * @version 1.0.0
 * @date 19-6-12 13:29
 */
@Controller
@RequestMapping
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    @GetMapping
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("title","家教在线");
        return mav;
    }

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("title","家教在线");
        return mav;
    }

    // sso测试接口
    @GetMapping("/user")
    public Authentication getUser(Authentication authentication) {
        log.info("auth : {}", authentication);
        return authentication;

    }
}
