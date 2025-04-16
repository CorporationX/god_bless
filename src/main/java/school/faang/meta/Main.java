package school.faang.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        manager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.printf("Sending EMAIL: %s%n", notification.getMessage()));
        manager.registerHandler(NotificationType.SMS,
                notification -> System.out.printf("Sending SMS: %s%n", notification.getMessage()));
        manager.registerHandler(NotificationType.PUSH,
                notification -> System.out.printf("Sending PUSH: %s%n", notification.getMessage()));
        Notification emailNotification = new Notification(NotificationType.EMAIL, "Welcome to the system");
        Notification smsNotification = new Notification(NotificationType.SMS, "You have a new SMS");
        Notification pushnotification = new Notification(NotificationType.PUSH, "You have a new PUSH");
    }
}