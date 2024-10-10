package school.faang;

import meta.universe.Notification;
import meta.universe.NotificationManager;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("sms", (notification) -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler("email", (notification) -> System.out.println("email: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("push: " + notification.getMessage()));

        Notification smsNotification = new Notification("sms", "You are blocked!");
        Notification emailNotification = new Notification("email", "You are allowed!");
        Notification pushNotification = new Notification("push", "Push notification is displayed!");
        Notification wrongNotification = new Notification("wrong", "empty");

        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(wrongNotification);
    }
}
