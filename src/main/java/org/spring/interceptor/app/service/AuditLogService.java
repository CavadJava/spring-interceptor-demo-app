package org.spring.interceptor.app.service;

import lombok.RequiredArgsConstructor;
import org.spring.interceptor.app.entity.AuditLog;
import org.spring.interceptor.app.repository.nodb.AuditLogRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final AuditLogRepository repository;

    public List<AuditLog> getAll() {
        return repository.getLogList();
    }

    @Async
    public AuditLog save(AuditLog auditLog) {
        Optional<AuditLog> auditLogOldOptional = repository.findById(auditLog.getUuid());
        if (auditLogOldOptional.isPresent()) {
            auditLog.setStatus(auditLog.getStatus());
            auditLog.setResponseBody(auditLog.getResponseBody());
            return saveAction(auditLog);
        } else {
            return saveAction(auditLog);
        }
    }

    @Async
    public AuditLog update(AuditLog auditLog) {
        Optional<AuditLog> auditLogOldOptional = repository.findById(auditLog.getUuid());
        if (auditLogOldOptional.isPresent()) {
            AuditLog log = auditLogOldOptional.get();
            log.setStatus(auditLog.getStatus());
            log.setResponseBody(auditLog.getResponseBody());
            return saveAction(log);
        } else {
            return saveAction(auditLog);
        }
    }

    private AuditLog saveAction(AuditLog auditLog) {
        return repository.save(auditLog);
    }

}
