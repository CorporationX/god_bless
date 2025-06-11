package school.faang.universe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificationTesting {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> log.info("Email: {}", notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> log.info("SMS: {}", notification.getMessage())
        );


        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
