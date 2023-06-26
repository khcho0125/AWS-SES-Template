package com.example.ses_email_template.ses.template;

import java.util.Map;

public interface EmailTemplate {
    String getName();
    Map<String, String> getData();
}

