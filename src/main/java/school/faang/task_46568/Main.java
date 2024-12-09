package school.faang.task_46568;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_46568.model.Notification;
import school.faang.task_46568.model.NotificationType;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL, notification -> {
            log.info("Sending by email: {}", notification.getMessage());
        });

        notificationManager.registerHandler(NotificationType.SMS, notification -> {
            log.info("Sending by SMS: {}", notification.getMessage());
        });

        notificationManager.registerHandler(NotificationType.PUSH, notification -> {
            log.info("Sending by PUSH: {}", notification.getMessage());
        });

        Notification emailNotification = new Notification(
                NotificationType.EMAIL,
                "Your account has been successfully activated"
        );
        Notification smsNotification = new Notification(
                NotificationType.SMS,
                "You have successfully changed your password"
        );
        Notification pushNotification = new Notification(
                NotificationType.PUSH,
                "New post from user: JohnDoe"
        );

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
