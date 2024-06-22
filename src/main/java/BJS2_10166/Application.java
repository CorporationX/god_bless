package BJS2_10166;

public class Application {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Sending by email: " + notification.message()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Sending SMS: " + notification.message()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Sending a push notification: " + notification.message()));

        Notification emailNotification = new Notification("email", "Your account has been successfully activated");
        Notification smsNotification = new Notification("sms", "You have successfully changed your password");
        Notification pushNotification = new Notification("push", "New post from user: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);



    }
}
