package school.faang.meta;

public class App {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(Notification.NotificationType.EMAIL, notification ->
                System.out.println("Sending email: " + notification.getMessage()));

        manager.setCorrector(notification -> new Notification(notification.getType(),
                notification.getMessage() + " - Sent by Company"));

        manager.registerHandler(Notification.NotificationType.SMS, notification ->
                System.out.println("Sending SMS: " + notification.getMessage()));

        manager.registerHandler(Notification.NotificationType.PUSH, notification ->
                System.out.println("Sending push notification: " + notification.getMessage()));


        Notification emailNotification = new Notification(Notification.NotificationType.EMAIL, "Hello via Email!");
        Notification smsNotification = new Notification(Notification.NotificationType.SMS, "Hello via SMS!");
        Notification pushNotification = new Notification(Notification.NotificationType.PUSH, "Hello via Push!");

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
    }
}
