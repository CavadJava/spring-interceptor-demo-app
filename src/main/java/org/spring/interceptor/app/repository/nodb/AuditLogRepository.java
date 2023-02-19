package org.spring.interceptor.app.repository.nodb;

import org.spring.interceptor.app.entity.AuditLog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AuditLogRepository {
    private static final List<AuditLog> logs;

    static {
        logs = new ArrayList<>();
    }

    public List<AuditLog> getLogList() {
        return logs;
    }

    public AuditLog save(AuditLog auditLog) {
        logs.add(auditLog);
        return auditLog;
    }


    public Optional<AuditLog> findById(String uuid) {
        return logs.stream()
                .filter((AuditLog auditLog) -> auditLog.getUuid().equals(uuid))
                .findFirst();
    }
}