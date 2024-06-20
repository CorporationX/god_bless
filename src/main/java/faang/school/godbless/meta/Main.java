package faang.school.godbless.meta;

public class Main {
    private static NotificationManager notificationManager = new NotificationManager();

    public static void main(String[] args) {
        notificationManager.registerHandler("email", (notification) -> System.out.println("Send from e-mail: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Send SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Send push-notifications: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Your account has been successfully activated");
        Notification smsNotification = new Notification("sms", "You have successfully changed your password");
        Notification pushNotification = new Notification("push","New post from user: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);


    }

}
