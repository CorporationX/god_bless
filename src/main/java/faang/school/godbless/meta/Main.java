package faang.school.godbless.meta;

public class Main {
    public static void main(String... args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Sending via email: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Sending SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Sending push-notification: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Your email is successfully registered");
        Notification smsNotification = new Notification("sms", "You have succesfully changd your password");
        Notification pushNotification = new Notification("push", "New post from: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
