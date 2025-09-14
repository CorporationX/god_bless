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
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение bububu!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.registerFilter("An unacceptable word in message! Please, edit your message",
                notification -> {
                    List<String> badWords = List.of("kuku", "bububu", "lyalyalya");
                    boolean filterPassed = true;
                    for (String badWord : badWords) {
                        if (notification.getMessage().contains(badWord)) {
                            filterPassed = false;
                            break;
                        }
                    }
                    return filterPassed;
                });

        System.out.println("\nAfter filter for bad words");
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.registerFilter("Notification type SMS not allowed",
                notification -> !notification.getType().equals(NotificationType.SMS));

        System.out.println("\nAfter filter for type SMS");
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.registerEditor(
                notification -> {
                    notification.setMessage(notification.getMessage() + " OOO Kukuyevo");
                    return notification;
                });

        System.out.println("\nAfter register editor");
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}