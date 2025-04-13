package school.faang.notification.main;

import lombok.extern.slf4j.Slf4j;
import school.faang.notification.model.Notification;
import school.faang.notification.service.NotificationManager;
import school.faang.notification.model.NotificationType;

import java.time.LocalTime;

@Slf4j
public class Main {

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        Notification emailNotification = new Notification(NotificationType.EMAIL,
                "Your account has been activated");
        Notification smsNotification = new Notification(NotificationType.SMS,
                "Your password has been changed");
        Notification pushNotification = new Notification(NotificationType.PUSH,
                "You have a new message");

        manager.addFilter(message -> !message.getMessage().toLowerCase().contains("spam"));
        manager.addFilter(message -> message.getMessage().length() <= 200);
        manager.addFilter(message -> {
            LocalTime time = LocalTime.now();
            return !time.isBefore(LocalTime.of(9, 0))
                    && !time.isAfter(LocalTime.of(18, 0));
        });

        manager.registerHandler(NotificationType.PUSH,
                notification -> log.info("Push: {}", notification.getMessage()));
        manager.registerHandler(NotificationType.EMAIL,
                notification -> log.info("Email: {}", notification.getMessage()));
        manager.registerHandler(NotificationType.SMS,
                notification -> log.info("SMS: {}", notification.getMessage()));
        manager.sendNotification(pushNotification);
        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
    }
}