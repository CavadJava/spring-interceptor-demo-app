package org.spring.interceptor.app.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoggingService {

    void displayReq(HttpServletRequest request, Object body) throws JsonProcessingException;

    void displayResp(HttpServletRequest request, HttpServletResponse response, Object body)
            throws JsonProcessingException;
}
