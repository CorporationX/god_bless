package school.faang.metauniverse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        // Отправка оповещений
        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        Notification newNotification = new Notification(NotificationType.PIGEON, "Прилетел почтовый голубь!");

        try {
            notificationManager.sendNotification(emailNotification);
            notificationManager.sendNotification(smsNotification);
            notificationManager.sendNotification(pushNotification);

            notificationManager.sendNotification(newNotification);
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
    }
}