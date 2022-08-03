package com.projectmanagement.util;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailSendService {

    private final JavaMailSender mailSender;

    public String sendMail(String to, String title, String body) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("projectmanagement");
        mailMessage.setTo(to);
        mailMessage.setSubject(title);
        mailMessage.setText(body);

        mailSender.send(mailMessage);

        return mailMessage.toString();
    }
}
