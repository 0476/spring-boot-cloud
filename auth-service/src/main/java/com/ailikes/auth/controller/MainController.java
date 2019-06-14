package com.ailikes.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 功能描述: TODO
 *
 * @ClassName IndexController
 * @Description
 * @Author ailikes
 * @Date 2019-06-01 15:07
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public ModelAndView home(){
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

    @GetMapping("/authIndex")
    public ModelAndView authIndex(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("title","家教在线");
        return mav;
    }

}
