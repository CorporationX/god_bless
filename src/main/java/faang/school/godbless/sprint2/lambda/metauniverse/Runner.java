package faang.school.godbless.sprint2.lambda.metauniverse;

public class Runner {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Register notification handlers
        notificationManager.registerHandler("email", notification -> System.out.println("Email sent: " + notification.getMessage()));
        notificationManager.registerHandler("sms", notification -> System.out.println("SMS sent: " + notification.getMessage()));
        notificationManager.registerHandler("push", notification -> System.out.println("Push notification sent: " + notification.getMessage()));

        // Send notifications
        Notification emailNotification = new Notification("email", "Your account has been activated.");
        Notification smsNotification = new Notification("sms", "Your password has been changed.");
        Notification pushNotification = new Notification("push", "You have a new message from JohnDoe.");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
