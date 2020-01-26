package controllers.servlets.filter;


import controllers.servlets.util.ServletsUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter (filterName = "RequestLoginFilter" , urlPatterns = {"" , "/addMessage", "/deleteTweet" , "/follow" , "/messages" , "/unfollow" , "/users", "/viewProfile"})
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userLoginFromSession = ServletsUtil.getUserLoginFromSession((HttpServletRequest) servletRequest);
        if (userLoginFromSession == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
