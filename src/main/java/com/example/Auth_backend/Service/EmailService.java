package com.example.Auth_backend.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendWelcomeEmail(String toEmail, String firstName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to Auth App!");
        message.setText(
                "Hi " + firstName + ",\n\n" +
                        "Welcome! Your account has been created successfully.\n\n" +
                        "You can now sign in and start using the app.\n\n" +
                        "Regards,\nAuth App Team");
        mailSender.send(message);
    }
}
