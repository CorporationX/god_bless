package school.faang.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.println("Email: " + notification.getMessage()));

        manager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));

        manager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push: " + notification.getMessage()));

        Notification email = new Notification(NotificationType.EMAIL, "Молодец");
        Notification sms = new Notification(NotificationType.SMS, "Пришла СМС");
        Notification push = new Notification(NotificationType.PUSH, "отправилось");

        manager.sendNotification(email);
        manager.sendNotification(sms);
        manager.sendNotification(push);
    }
}
