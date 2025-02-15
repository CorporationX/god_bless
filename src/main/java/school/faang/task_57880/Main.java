package school.faang.task_57880;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(
                NotificationType.EMAIL,
                notification -> log.info("Email: {}", notification.getMessage()));

        manager.registerHandler(
                NotificationType.SMS,
                notification -> log.info("SMS: {}", notification.getMessage()));

        manager.registerHandler(
                NotificationType.PUSH,
                notification -> log.info("Push: {}", notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Email message");
        Notification smsNotification = new Notification(NotificationType.SMS, "SMS message");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Push message");
        Notification godNotification = new Notification(NotificationType.VODKA, "VODKA message");

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
        manager.sendNotification(godNotification);
    }
}
