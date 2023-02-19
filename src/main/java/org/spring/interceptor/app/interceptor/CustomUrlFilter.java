package org.spring.interceptor.app.interceptor;

import org.spring.interceptor.app.constant.Constant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.UUID;

public class CustomUrlFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String requestId = UUID.randomUUID().toString().concat("-").concat(System.nanoTime() + "-xxx");
        servletRequest.setAttribute(Constant.REQUEST_ID, requestId);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
