package school.faang.meta_universe;

public class Test {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.println("Email: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS, notification ->
                System.out.println("SMS: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH, notification ->
                System.out.println("Push: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH, notification ->
                System.out.println("Push " + notification.getMessage()));

        notificationManager.addFilter(notification -> !notification.getMessage().toLowerCase().contains("spam"));
        notificationManager.addCorrector(notification ->
                new Notification(notification.getType(), notification.getMessage() + " [Meta Corp]"));

        notificationManager.sendNotification(new Notification(NotificationType.EMAIL, "Herzlich Wilkommen!"));
        notificationManager.sendNotification(new Notification(NotificationType.SMS, "SPAM!"));
        notificationManager.sendNotification(new Notification(NotificationType.PUSH, "New message is available"));

    }
}