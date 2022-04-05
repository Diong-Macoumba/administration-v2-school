package com.ecole.MySchoo.dto.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {

    private String username;
    private String access_token;
    private String refresh_token;
    private String expireAt;
    private String[] roles;
}
