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

        System.out.println("*******************************");

        notificationManager.setFilterWords(List.of("Sms", "Email"));
        listNotifications.forEach(notificationManager::sendFilteredNotification);

        System.out.println("*******************************");

        notificationManager.sendSignedNotification("Google", listNotifications.get(0));
    }
}
