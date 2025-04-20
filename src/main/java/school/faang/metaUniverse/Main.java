package school.faang.metaUniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL, n -> System.out.println("EMAIL:" + n.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS, n -> System.out.println("SMS: " + n.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH, n -> System.out.println("PUSH: " + n.getMessage()));

        notificationManager.sendNotification(new Notification(NotificationType.EMAIL, "Cообщение отправлено е-мэйл"));
        notificationManager.sendNotification(new Notification(NotificationType.SMS, "Cообщение отправлено по смс"));
        notificationManager.sendNotification(new Notification(NotificationType.PUSH, "Cообщение отправлено пушом"));
    }
}