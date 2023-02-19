package org.spring.interceptor.app.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Card implements Serializable {

    private String id;
    private String customerNo;
    private String type;
    private String fullName;

}
