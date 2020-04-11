package com.gm.interceptor;

        import org.springframework.web.servlet.HandlerInterceptor;
        import org.springframework.web.servlet.ModelAndView;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;

/**
 * 2020/3/2 9:48
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //再拦截点进行拦截，如果返回true，则不执行拦截点后的操作（拦截成功）
        //1、判断当前的User用户不为空
        //2、获取当前登录方法

        HttpSession session = request.getSession();
        String url = request.getRequestURI();
        System.out.println("接受到的action为："+url);
//          || url.indexOf("user/doLogin.do")!=-1
        if (session.getAttribute("userInfo")!=null){
            return true;
        }else {
            //进行拦截，返回登陆页面
            response.sendRedirect(request.getContextPath()+"user/doLogin.do");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //在处理过程中，执行拦截
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //执行完毕，返回前拦截


    }
}
