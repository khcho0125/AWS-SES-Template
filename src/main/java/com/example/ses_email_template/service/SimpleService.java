package com.example.ses_email_template.service;

import com.example.ses_email_template.service.request.AuthenticateRequest;
import com.example.ses_email_template.service.request.WelcomeRequest;
import com.example.ses_email_template.ses.EmailService;
import com.example.ses_email_template.ses.template.AuthenticateTemplate;
import com.example.ses_email_template.ses.template.WelcomeTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleService {

    private final EmailService emailService;

    public void welcome(WelcomeRequest request) {
        WelcomeTemplate template = new WelcomeTemplate(request.getUsername(), request.getProfile(), request.getLink());
        emailService.sendEmail(template);
    }

    public void authenticate(AuthenticateRequest request) {
        AuthenticateTemplate template = new AuthenticateTemplate(request.getCode());
        emailService.sendEmail(template);
    }
}
