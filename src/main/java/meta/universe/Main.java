package meta.universe;

public class Main {
    public static void main(String[] args) {
        Notification sms = new Notification(NotificationType.SMS, "How are you nigga?");
        Notification meeting = new Notification(NotificationType.EMAIL, "Midnight meeting about parallelepiped!");
        Notification push = new Notification(NotificationType.PUSH, "Your favorite channel posted a new video!");

        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.printf("SMS: %s%n", notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.printf("PUSH: %s%n", notification.getMessage()));
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.printf("EMAIL: %s%n", notification.getMessage()));

        notificationManager.addFilter(notification -> notification.getMessage().contains("nigga"));
        notificationManager.addFilter(notification -> notification.getMessage().contains("kill"));
        notificationManager.addFilter(notification -> notification.getMessage().contains("parallelepiped"));

        notificationManager.sendNotification(sms);
        notificationManager.sendNotification(meeting);
        notificationManager.sendNotification(push);
    }
}
