package com.example.ses_email_template.ses.template;

import java.util.HashMap;
import java.util.Map;

public class AuthenticateTemplate implements EmailTemplate {

    private static final String name = "Authenticate VerifyCode Template";

    private static final String code = "CODE";

    private final Map<String, String> data = new HashMap<>();

    public AuthenticateTemplate(String code) {
        data.put(AuthenticateTemplate.code, code);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, String> getData() {
        return data;
    }
}
