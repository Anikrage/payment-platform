package com.payment.notification.controller;

import com.payment.notification.model.Notification;
import com.payment.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/list")
    public List<Notification> getNotifications() {
        // For testing - create sample notifications
        Notification notification1 = new Notification();
        notification1.setUserId("user123");
        notification1.setMessage("Payment received");
        notification1.setTimestamp(LocalDateTime.now());
        notificationRepository.save(notification1);
        
        Notification notification2 = new Notification();
        notification2.setUserId("user456");
        notification2.setMessage("Transaction complete");
        notification2.setTimestamp(LocalDateTime.now());
        notificationRepository.save(notification2);
        
        return notificationRepository.findAll();
    }
}
