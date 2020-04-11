package com.gm.filter;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 2020/3/2 10:27
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //过滤器出生
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //servletRequest 是接口，HttpServlerRequest 是实现，但是有些方法是HttpServletRequest独有的，你如说getServlet
        //HttpServlerRequest 接口是继承自servlerRequest接口，增加了和Http相关方法

        //强转得到想要的request和response
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        //获取session
        HttpSession session=request.getSession();
        if (session.getAttribute("userInfo")==null&&request.getRequestURI().indexOf("user/doLogin.do")==-1){
            //没有登陆
            response.sendRedirect(request.getContextPath()+"/user/doLogin.do");
        }else {
            //已经登录，继续下一个请求（继续访问）
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
