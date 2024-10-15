package school.faang.metaunivers;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Registering notification handlers
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Sending email: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Sending SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Sending push notification: " + notification.getMessage())
        );

        // Sending notifications
        Notification emailNotification = new Notification("email", "Your account has been successfully + " +
                " + activated.");
        Notification smsNotification = new Notification("sms", "You have successfully changed your  + " +
                " + password.");
        Notification pushNotification = new Notification("push", "New post from user: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}

