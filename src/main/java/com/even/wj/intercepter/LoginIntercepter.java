package com.even.wj.intercepter;

import com.even.wj.domain.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录拦截器
 */
public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws IOException {
        //获取session
        HttpSession session = request.getSession();
        //获取访问路径
        String contextPath = session.getServletContext().getContextPath();

        String[] requireaAuthPages = new String[]{"index",};

        String requestURI = request.getRequestURI();

        requestURI = StringUtils.remove(requestURI, contextPath + "/");
        String page = requestURI;
        if(benginWith(page,requireaAuthPages)){
            User user = (User) session.getAttribute("user");
            if(user == null){
                response.sendRedirect("login");
                return false;
            }
        }
        return true;
    }

    /**
     * 功能：判断请求
     * @param page
     * @param requireaAuthPages
     * @return
     */
    private boolean benginWith(String page,String[] requireaAuthPages){
        boolean result = false;
        for (String requireaAuthPage :requireaAuthPages){
            if(StringUtils.startsWith(page,requireaAuthPage)){
                result = true;
                break;
            }
        }
        return result;
    }
}
