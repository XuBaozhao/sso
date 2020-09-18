package com.bupt.ssoclienttaobao.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TaobaoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断会话是否存在
        HttpSession session = request.getSession();
        Boolean isLogin = (Boolean) session.getAttribute("isLogin");

        // 如果session中isLogin == true，说明自己登陆过了，直接访问
        if(isLogin!=null && isLogin){
            return true;
        }

        //判断token
        String token = request.getParameter("token");

        System.out.println("token： " + token);

        // 如果token不为空，说明自己没登录，别人登陆过了，自己保存信息，也是返回true
        if(!StringUtils.isEmpty(token)){
                Cookie cookie = new Cookie("token", token);
                response.addCookie(cookie);
                session.setAttribute("isLogin", true);
                return true;
        }

        System.out.println("进到这里来。。。");

        // token为空，登录认证
        response.sendRedirect("http://localhost:8081/checkToken?url=http://localhost:8080/taobao");
        return false;
    }
}