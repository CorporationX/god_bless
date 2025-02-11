package school.faang.task_60088;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager(new HashMap<>());

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL,
                "Your account has been activated");
        Notification smsNotification = new Notification(NotificationType.SMS,
                "Your password has been changed");
        Notification pushNotification = new Notification(NotificationType.PUSH,
                "You have a new message!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
