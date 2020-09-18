package com.bupt.ssoclienttaobao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Controller
public class TaobaoController {


    public static final String PAYMENT_URL = "http://localhost:8081";

    @Resource
    private RestTemplate restTemplate;

//    @GetMapping(value = "/test")
//    public String create(){
//        return restTemplate.getForObject(PAYMENT_URL+"/remote", String.class);
//    }

    @GetMapping("/index")
    public String index2(){
        return "index";
    }

    // 进入淘宝页面
    @GetMapping("/taobao")
    public String index(){
        return "index";
    }
}
