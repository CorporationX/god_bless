package faang.school.Meta;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL, notification ->
                log.info("Email: {}", notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS, notification ->
                log.info("SMS: {}", notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH, notification ->
                log.info("Push Notification: {}", notification.getMessage()));

        notificationManager.sendNotification(new Notification(NotificationType.PUSH,
                "У вас новое сообщение!"));
        notificationManager.sendNotification(new Notification(NotificationType.PUSH,
                "У вас 5 непрочитнных сообщений!"));
    }
}
