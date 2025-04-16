package school.faang.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(NotificationType.EMAIL,
                n -> System.out.println("Email: " + n.getMessage()));
        manager.registerHandler(NotificationType.SMS,
                n -> System.out.println("SMS: " + n.getMessage()));
        manager.registerHandler(NotificationType.PUSH,
                n -> System.out.println("Push: " + n.getMessage()));

        manager.addFilter(n -> !n.getMessage().toLowerCase().contains("spam"));

        manager.addCorrector(n ->
                new Notification(n.getType(), n.getMessage() + " [Meta Corp]"));

        manager.sendNotification(new Notification(NotificationType.EMAIL, "Herzlich Wilkommen!"));
        manager.sendNotification(new Notification(NotificationType.SMS, "SPAM!"));
        manager.sendNotification(new Notification(NotificationType.PUSH, "New message is available"));
    }
}
