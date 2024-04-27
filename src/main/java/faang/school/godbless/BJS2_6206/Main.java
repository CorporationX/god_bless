package faang.school.godbless.BJS2_6206;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Sending email: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Sending SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Sending Push Notification: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Your account has been activated");
        Notification smsNotification = new Notification("sms", "Your password has been changed successfully");
        Notification pushNotification = new Notification("push", "New post from user: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
