package school.faang.bjs2_70620;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> log.info("Sending email with message '{}'", notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> log.info("Sending sms with message '{}'", notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> log.info("Sending push with message '{}'", notification.getMessage()));

        notificationManager.sendNotification(new Notification(NotificationType.EMAIL, "Hello, world!"));
        notificationManager.sendNotification(new Notification(NotificationType.SMS, "Hello, world!"));
        notificationManager.sendNotification(new Notification(NotificationType.PUSH, "Hello, world!"));
        notificationManager.sendNotification(new Notification(NotificationType.EMAIL, "Association"));
    }
}