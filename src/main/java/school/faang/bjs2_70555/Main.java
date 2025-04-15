package school.faang.bjs2_70555;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL, new NotificationHandler<>(
                notification -> notification.getMessage().contains("non censored text"),
                notification -> "%s \n%s".formatted(notification.getMessage(), "Signature for EMAIL"),
                notification -> log.info("Email: {}", notification.getMessage()))
        );

        notificationManager.registerHandler(NotificationType.SMS, new NotificationHandler<>(
                notification -> notification.getMessage().contains("non censored text"),
                notification -> "%s \n%s".formatted(notification.getMessage(), "Signature for SMS"),
                notification -> log.info("SMS: {}", notification.getMessage()))
        );

        notificationManager.registerHandler(NotificationType.PUSH, new NotificationHandler<>(
                notification -> notification.getMessage().contains("non censored text"),
                notification -> "%s \n%s".formatted(notification.getMessage(), "Signature for PUSH"),
                notification -> log.info("PUSH: {}", notification.getMessage()))
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account is active");
        Notification emailNotificationFailure = new Notification(NotificationType.EMAIL,
                "Somebody text, non censored text.");
        Notification smsNotification = new Notification(NotificationType.SMS, "Your password is changed.");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Your have new message!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(emailNotificationFailure);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}