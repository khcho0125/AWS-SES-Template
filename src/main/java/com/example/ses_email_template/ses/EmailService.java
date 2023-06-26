package com.example.ses_email_template.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.CreateTemplateRequest;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.SendTemplatedEmailRequest;
import com.amazonaws.services.simpleemail.model.Template;
import com.example.ses_email_template.ses.template.EmailTemplate;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Value("${mail.source}")
    private String source;

    public void sendEmail(EmailTemplate template, String... emails) {
        Destination des = new Destination();
        des.setToAddresses(Arrays.asList(emails));

        String templateData = new Gson().toJson(template.getData());

        SendTemplatedEmailRequest emailRequest = new SendTemplatedEmailRequest();
        emailRequest.setTemplate(template.getName());
        emailRequest.setDestination(des);
        emailRequest.setSource(source);
        emailRequest.setTemplateData(templateData);

        amazonSimpleEmailService.sendTemplatedEmail(emailRequest);
    }

    public void createTemplate(String name, String subject, String htmlTemplate) {
        Template template = new Template();
        template.setTemplateName(name);
        template.setSubjectPart(subject);
        template.setHtmlPart(htmlTemplate);

        CreateTemplateRequest request = new CreateTemplateRequest().withTemplate(template);
        amazonSimpleEmailService.createTemplate(request);
    }
}
