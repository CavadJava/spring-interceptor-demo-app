package org.spring.interceptor.app.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class InterceptLog implements HandlerInterceptor {

    private final LoggingService loggingService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws JsonProcessingException {
        if (request.getMethod().equals(HttpMethod.GET.name())
                || request.getMethod().equals(HttpMethod.DELETE.name())) {
            loggingService.displayReq(request, null);
        }
        return true;
    }
}
