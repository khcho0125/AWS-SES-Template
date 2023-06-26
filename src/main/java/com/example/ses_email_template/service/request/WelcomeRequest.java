package com.example.ses_email_template.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WelcomeRequest {

    private String username;
    private String profile;
    private String link;
}
