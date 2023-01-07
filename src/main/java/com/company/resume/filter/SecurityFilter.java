package com.company.resume.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName="JSPFileFilter2",urlPatterns = {"*"})
public class SecurityFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            if (!req.getRequestURI().contains("/login") && req.getSession().getAttribute("loggedInUser") == null) {
                res.sendRedirect("login");
            } else {
                chain.doFilter(request, response);       //bunsuz islemirdi. mellim search edib tapdii bu methodu. Etdiyi is prosesin davamliligini getirmekdir. Yeni onsuz proses else senaryosundda dayanirdi, servler'mze catmirdi. Amma bu method ile dayanmamasini else senaryosunda sonraki addima kecib servlet'e catmasini dedik.
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}