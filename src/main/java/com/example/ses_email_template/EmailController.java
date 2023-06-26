package com.example.ses_email_template;

import com.example.ses_email_template.service.SimpleService;
import com.example.ses_email_template.service.request.AuthenticateRequest;
import com.example.ses_email_template.service.request.WelcomeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class EmailController {

    private final SimpleService service;

    @PostMapping("/welcome")
    public void welcomeMail(@RequestBody WelcomeRequest request) {
        service.welcome(request);
    }

    @PostMapping("/auth")
    public void authenticateMail(@RequestBody AuthenticateRequest request) {
        service.authenticate(request);
    }
}
