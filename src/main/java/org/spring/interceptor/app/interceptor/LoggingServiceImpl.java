package org.spring.interceptor.app.interceptor;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.interceptor.app.constant.Constant;
import org.spring.interceptor.app.entity.AuditLog;
import org.spring.interceptor.app.service.AuditLogService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoggingServiceImpl implements LoggingService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final AuditLogService service;

    @Override
    public void displayReq(HttpServletRequest request, Object body) throws JsonProcessingException {
        AuditLog auditLog = createLog(request);
        if (auditLog != null) {
            auditLog.setRequestBody(getBody(body));
            service.save(auditLog);
        }
    }

    @Override
    public void displayResp(HttpServletRequest request, HttpServletResponse response, Object body)
            throws JsonProcessingException {
        AuditLog auditLog = createLog(request);
        if (auditLog != null) {
            auditLog.setStatus(response.getStatus());
            auditLog.setResponseBody(getBody(body));
            service.update(auditLog);
        }
    }

    private AuditLog createLog(HttpServletRequest request) {
        Object requestId = request.getAttribute(Constant.REQUEST_ID);
        if (Objects.nonNull(requestId)) {
            return AuditLog.builder()
                    .uuid(requestId.toString())
                    .method(request.getMethod())
                    .path(request.getRequestURI())
                    .build();
        }
        return null;
    }

    private String getBody(Object body) throws JsonProcessingException {
        return Objects.nonNull(body) ? toJson(body) : "";
    }

    private static String toJson(Object body) throws JsonProcessingException {
        if (body != null) {
            return MAPPER.writeValueAsString(body);
        }
        return "";
    }
}
