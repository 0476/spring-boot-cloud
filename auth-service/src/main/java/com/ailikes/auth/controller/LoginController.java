package com.ailikes.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 功能描述:登录
 *
 * @author 徐大伟
 * @version 1.0.0
 * @date 19-6-14 18:52
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("title","登录");
        return mav;
    }
}
