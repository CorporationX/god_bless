package Meta;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.STOP,
                notification -> System.out.println("STOP: " + notification.getMessage()));

        notificationManager.setFilter(notification -> {
            String message = notification.getMessage().toLowerCase();
            return !message.contains("Цензура");
        });

        List<Notification> notifications = Arrays.asList(
                new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован"),
                new Notification(NotificationType.SMS, "Ваш пароль изменен"),
                new Notification(NotificationType.PUSH, "У вас новое сообщение!"),
                new Notification(NotificationType.STOP, "Сообщение содержит слово Цензура")
        );

        for (Notification notification : notifications) {
            notificationManager.sendNotification(notification);
        }
    }
}

