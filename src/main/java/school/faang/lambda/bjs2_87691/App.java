package school.faang.lambda.bjs2_87691;

import java.util.List;

public class App {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован.");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен.");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification pushNotification2 = new Notification(NotificationType.PUSH, "У вас новое сообщение bububu!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.sendNotificationWithFilter(pushNotification2, message -> {
            List<String> badWords = List.of("kuku", "bububu", "lyalyalya");
            boolean containsBadWord = false;
            for (String badWord : badWords) {
                if (message.contains(badWord)) {
                    containsBadWord = true;
                    break;
                }
            }
            return containsBadWord;
        });

        notificationManager.sendNotificationWithEditor(smsNotification,
                notification -> {
                    notification.setMessage(notification.getMessage() + " OOO Kukuyevo");
                    return notification;
                });
    }
}