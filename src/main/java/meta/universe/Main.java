package meta.universe;

public class Main {
    public static void main(String[] args) {
        var notificationManager = new NotificationManager();
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Sending email: " + notification.getMessage()));
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Sending sms: " + notification.getMessage()));
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Sending push-notification: " + notification.getMessage()));
        var emailNotification = new Notification("email", "Your account is activated");
        var smsNotification = new Notification("sms", "Your code is 0000");
        var pushNotification = new Notification("push", "You have new message");
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
