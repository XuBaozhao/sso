package com.bupt.ssoserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Controller
public class Testcontroller {

    // 进入登陆页面
    @GetMapping("/login")
    public String index(){
        return "login";
    }

    public static final String PAYMENT_URL = "http://localhost:8080";

    @Resource
    private RestTemplate restTemplate;

    // 判断登陆逻辑
    @PostMapping("userlogin")
    public String login(HttpServletRequest httpServletRequest, HttpSession session) throws IOException {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");

        if(username.equals("1") && password.equals("1")){
            String token = UUID.randomUUID().toString();
            // 设置servlet上下文信息
            session.getServletContext().setAttribute("token", token);
            // 进入淘宝主页
            return "redirect:"+"http://localhost:8080/taobao"+"?token="+token;
        }
        return "error";
    }

    @GetMapping("/checkToken")
    public String checkToken(HttpServletRequest request, HttpSession session){

        String url = request.getParameter("url");
        String token = (String) session.getServletContext().getAttribute("token");

        // 如果token空，登陆
        if(StringUtils.isEmpty(token)){
            return "login";
        }else{
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if(cookie.getValue().equals(token)){
                    return "redirect:"+url+"?token="+token;
                }
            }
            return "login";
        }
    }
}
