package org.spring.interceptor.app.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog implements Serializable {

    private String uuid;
    private String method;
    private String path;
    private String requestBody;
    private String responseBody;
    private int status;
}
