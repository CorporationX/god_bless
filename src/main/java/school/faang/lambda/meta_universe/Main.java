package school.faang.lambda.meta_universe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> log.info("Email: {}", notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> log.info("SMS: {}", notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> log.info("Push Notification: {}", notification.getMessage())
        );

        // Отправка оповещений
        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification wrongNotification = new Notification(NotificationType.EMAIL, "**Ваш аккаунт активирован**");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification nullNotification = new Notification(null, null);

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(wrongNotification);
        notificationManager.sendNotification(nullNotification);

        emailNotification = notificationManager.fillSender(emailNotification,
                notification -> new Notification(notification.getType(),
                        notification.getMessage() + " - From Me"));
        notificationManager.sendNotification(emailNotification);
    }
}
