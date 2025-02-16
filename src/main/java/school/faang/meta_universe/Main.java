package school.faang.meta_universe;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL, notification -> {
            System.out.println("Email: " + notification.getMessage());
        });
        notificationManager.registerHandler(NotificationType.SMS, notification -> {
            System.out.println("Sms: " + notification.getMessage());
        });
        notificationManager.registerHandler(NotificationType.PUSH, notification -> {
            System.out.println("Push: " + notification.getMessage());
        });

        var listNotifications = List.of(new Notification(NotificationType.EMAIL, "Email received: Hello, Universe!"),
                new Notification(NotificationType.SMS, "Sms received: Hello, Universe!"),
                new Notification(NotificationType.PUSH, "Push received: Hello, Universe!"));

        listNotifications.forEach(notificationManager::sendNotification);

        System.out.println("**************WITH FILTERING*****************");
        notificationManager.setFilterWords(List.of("Sms", "Email"));
        listNotifications.forEach(notificationManager::sendFilteredNotification);

        System.out.println("****************AFTER ADDED SIGN***************");
        listNotifications.forEach(note -> notificationManager
                .sendSignedNotification("Google", note));

        System.out.println("****************AFTER DELETED EMAIL HANDLER***************");
        notificationManager.removeNotificationHandler(NotificationType.PUSH);
        listNotifications.forEach(notificationManager::sendNotification);
    }
}
