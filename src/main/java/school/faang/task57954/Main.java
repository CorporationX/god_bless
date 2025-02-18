package school.faang.task57954;

import school.faang.task57954.notification.Notification;
import school.faang.task57954.notification.NotificationManager;
import school.faang.task57954.notification.NotificationType;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        // Регистрация обработчиков оповещений
        setupHandlers(notificationManager);
        // Отправка оповещений
        setupNotifications(notificationManager);
    }

    public static void setupHandlers(NotificationManager notificationManager) {
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );
    }

    public static void setupNotifications(NotificationManager notificationManager) {
        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification smsBadNotification = new Notification(NotificationType.SMS, "Ты багет");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(smsBadNotification);

        Function<Notification, Notification> addCompanyToMessage = notification -> {
            notification.setMessage(notification.getMessage() + "\nВаша компания.");
            return notification;
        };

        notificationManager.sendNotification(
                notificationManager.addSignatureForMessage(smsNotification, addCompanyToMessage));
    }
}
