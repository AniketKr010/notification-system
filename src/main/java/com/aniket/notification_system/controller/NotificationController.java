package com.aniket.notification_system.controller;

import com.aniket.notification_system.model.Notification;
import com.aniket.notification_system.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Send single email
    @PostMapping("/send")
    public Notification sendEmail(@RequestBody Map<String, String> request) {
        String toEmail = request.get("toEmail");
        String subject = request.get("subject");
        String body = request.get("body");
        return notificationService.sendEmail(toEmail, subject, body);
    }

    // Send bulk emails
    @PostMapping("/send-bulk")
    public String sendBulkEmails(@RequestBody Map<String, Object> request) {
        List<String> emails = (List<String>) request.get("emails");
        String subject = (String) request.get("subject");
        String body = (String) request.get("body");
        notificationService.sendBulkEmails(emails, subject, body);
        return "Bulk emails sent successfully!";
    }

    // Get all notifications
    @GetMapping("/all")
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
}