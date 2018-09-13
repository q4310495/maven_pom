package com.qf.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping("/{home}")
    public String tohome(@PathVariable("home")String home){
        return home;
    }

}
