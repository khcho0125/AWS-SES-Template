package com.example.ses_email_template.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticateRequest {
    private String code;
}
