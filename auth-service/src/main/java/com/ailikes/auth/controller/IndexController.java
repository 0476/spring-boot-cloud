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
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("title","用户中心");
        return mav;
    }

    @GetMapping("/main")
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("title","用户中心");
        return mav;
    }
}
