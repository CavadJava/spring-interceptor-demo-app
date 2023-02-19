package org.spring.interceptor.app.controller;

import lombok.RequiredArgsConstructor;
import org.spring.interceptor.app.entity.AuditLog;
import org.spring.interceptor.app.service.AuditLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audit/log")
@RequiredArgsConstructor
public class LogController {

    private final AuditLogService auditLogService;

    @GetMapping
    public List<AuditLog> save() {
        return auditLogService.getAll();
    }
}
