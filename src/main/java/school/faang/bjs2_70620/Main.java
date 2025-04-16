package school.faang.bjs2_70620;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.printf("Sending email with message '%s'%n", notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.printf("Sending sms with message '%s'%n", notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.printf("Sending push with message '%s'%n", notification.getMessage()));

        notificationManager.sendNotification(new Notification(NotificationType.EMAIL, "Hello, world!"));
        notificationManager.sendNotification(new Notification(NotificationType.SMS, "Hello, world!"));
        notificationManager.sendNotification(new Notification(NotificationType.PUSH, "Hello, world!"));
        notificationManager.sendNotification(new Notification(NotificationType.EMAIL, "Association"));
    }
}