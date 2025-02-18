package school.faang.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(Notification.NotificationType.EMAIL, notification ->
                System.out.println("Email: " + notification.getMessage()));
        notificationManager.registerHandler(Notification.NotificationType.SMS, notification ->
                System.out.println("SMS: " + notification.getMessage()));

        Notification defaultNotification = notificationManager.createDefaultNotification();
        System.out.println("Created notification: " + defaultNotification.getMessage());
        notificationManager.sendNotification(defaultNotification);

        Notification priorityNotification = new Notification(Notification.NotificationType.PUSH,
                "Important notification!");
        notificationManager.sendNotificationWithPriority(priorityNotification, "high");

        Notification smsNotification = new Notification(Notification.NotificationType.SMS,
                "Confirmation code for account login");
        notificationManager.sendNotification(smsNotification);
    }
}
