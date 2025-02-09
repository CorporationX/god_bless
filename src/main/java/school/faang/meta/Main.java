package school.faang.meta;

import java.util.Map;

public class Main {
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

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account was activated");
        Notification smsNotification = new Notification(NotificationType.SMS, "Your password was changed");
        Notification pushNotification = new Notification(NotificationType.PUSH, "You have new notification!");
        Notification callNotification = new Notification(NotificationType.CALL, "You are active user");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        //notificationManager.sendNotification(callNotification);
    }
}
