package com.bupt.ssoclienttmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TmallController {

    @GetMapping("/tmall")
    public String index(){
        return "index";
    }
}