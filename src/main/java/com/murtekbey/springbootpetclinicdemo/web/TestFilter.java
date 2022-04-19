package com.murtekbey.springbootpetclinicdemo.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/TestServlet")
public class TestFilter implements Filter {

    public TestFilter() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.getWriter().write("before...");
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.getWriter().write("after...");
    }

}
