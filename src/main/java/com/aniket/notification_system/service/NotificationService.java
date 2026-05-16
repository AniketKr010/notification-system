package com.aniket.notification_system.service;

import com.aniket.notification_system.model.Notification;
import com.aniket.notification_system.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NotificationRepository notificationRepository;

    // Send single email
    public Notification sendEmail(String toEmail, String subject, String body) {
        Notification notification = new Notification();
        notification.setToEmail(toEmail);
        notification.setSubject(subject);
        notification.setBody(body);
        notification.setCreatedAt(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
            notification.setStatus("SENT");
        } catch (Exception e) {
            notification.setStatus("FAILED");
        }

        return notificationRepository.save(notification);
    }

    // Send bulk emails
    public void sendBulkEmails(List<String> emails, String subject, String body) {
        for (String email : emails) {
            sendEmail(email, subject, body);
        }
    }

    // Get all notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}