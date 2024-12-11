package school.faang.metabjs46838;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                notification -> System.out.println("Send by email: " + notification.getMessage()));

        notificationManager.registerHandler("sms",
                notification -> System.out.println("Send by sms: " + notification.getMessage()));

        notificationManager.registerHandler("push",
                notification -> System.out.println("Send by push: " + notification.getMessage()));

        Notification emailNotification = new Notification("email",
                "Your account has been successfully activated");
        Notification smsNotification = new Notification("sms",
                "You have successfully changed your password");
        Notification pushNotification = new Notification("push",
                "New post from user: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
