package com.ailikes.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 功能描述:
 *
 * @author 徐大伟
 * @version 1.0.0
 * @date 19-6-13 11:59
 */
@Controller
@RequestMapping
public class PersonInfoController {

    @Autowired
    private RestOperations restOperations;

    @GetMapping("/personInfo")
    public ModelAndView person() {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        String personResourceUrl = "http://localhost:5000/person";
        mav.addObject("person", restOperations.getForObject(personResourceUrl, String.class));
        return mav;
    }
}
