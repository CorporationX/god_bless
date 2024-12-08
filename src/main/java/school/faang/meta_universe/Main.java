package school.faang.meta_universe;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Sending by SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Sending push-notification: " + notification.getMessage())
        );

        Notification smsNotification = new Notification("sms", "Your password successfully changed");
        Notification pushNotification = new Notification("push", "User John posted new stories");
        Notification emailNotification = new Notification("email", "Someone sending email");

        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(emailNotification);
    }
}