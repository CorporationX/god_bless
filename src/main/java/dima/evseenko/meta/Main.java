package dima.evseenko.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager nm = new NotificationManager();
        nm.registerHandler(NotificationType.SMS, (notification) -> System.out.println("Sms notification: " + notification.getMessage()));
        nm.registerHandler(NotificationType.EMAIL, (notification) -> System.out.println("Email notification: " + notification.getMessage()));
        nm.registerHandler(NotificationType.PUSH, (notification) -> System.out.println("Push notification: " + notification.getMessage()));

        nm.sendNotification(new Notification(NotificationType.SMS, "Hello sms"));
        nm.sendNotification(new Notification(NotificationType.EMAIL, "Hello email"));
        nm.sendNotification(new Notification(NotificationType.PUSH, "Hello pussy push"));
    }
}
