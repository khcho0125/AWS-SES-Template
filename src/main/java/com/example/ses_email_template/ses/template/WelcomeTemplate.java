package com.example.ses_email_template.ses.template;

import java.util.HashMap;
import java.util.Map;

public class WelcomeTemplate implements EmailTemplate {

    private static final String name = "Welcome Template";

    private static final String username = "USER_NAME";
    private static final String profile = "PROFILE";
    private static final String link = "LINK";

    private final Map<String, String> data = new HashMap<>();

    public WelcomeTemplate(String username, String profile, String link) {
        data.put(WelcomeTemplate.username, username);
        data.put(WelcomeTemplate.profile, profile);
        data.put(WelcomeTemplate.link, link);
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
