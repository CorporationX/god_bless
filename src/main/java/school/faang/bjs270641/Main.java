package school.faang.bjs270641;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.message())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.message())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.message())
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account activated.");
        Notification smsNotification = new Notification(NotificationType.SMS, "Your password changed.");
        Notification pushNotification = new Notification(NotificationType.PUSH, "You have new message!");

        notificationManager.sendNotification(emailNotification,
                notification -> notification.type() == NotificationType.EMAIL,
                notification -> new Notification(notification.type(), "Transformed: " + notification.message())
        );
        notificationManager.sendNotification(smsNotification,
                notification -> notification.type() == NotificationType.SMS,
                notification -> new Notification(notification.type(), "Transformed: " + notification.message())
        );
        notificationManager.sendNotification(pushNotification,
                notification -> notification.type() == NotificationType.PUSH,
                notification -> new Notification(notification.type(), "Transformed: " + notification.message())
        );

    }
}
