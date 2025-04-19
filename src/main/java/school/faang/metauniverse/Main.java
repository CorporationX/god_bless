package school.faang.metauniverse;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        List<String> badWords = List.of("nigger", "nigga", "deputat");

        notificationManager.setFilter(notification -> {
            String message = notification.getMessage().toLowerCase();
            for (String badWord : badWords) {
                if (message.contains(badWord)) {
                    System.out.printf("Сообщение содержит плохое слово %s ", badWord);
                    return false;
                }
            }
            return true;
        });

        notificationManager.setCorrector(notification ->
                new Notification(
                        notification.getType(),
                        notification.getMessage() + "\n-- Команда MetaUniverse"
                )
        );

        notificationManager.registerHandler(NotificationType.SMS, notification ->
                System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.println("Email: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH, notification ->
                System.out.println("Push: " + notification.getMessage()));

        Notification smsNotification = new Notification(NotificationType.SMS, "deputat");
        Notification emailNotification = new Notification(NotificationType.EMAIL, "New message");
        Notification pushNotification = new Notification(NotificationType.PUSH, "New push");

        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
