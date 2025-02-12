package school.faang.naughtwoBJS257688;


public class Main {
    public static void main(String[] arg) {
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

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account has been activated.");
        Notification smsNotification = new Notification(NotificationType.SMS, "Your password has been changed.");
        Notification pushNotification = new Notification(NotificationType.PUSH, "You've got mail!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
