package school.faang.bjs246807;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("email",
                notification -> System.out.println("Sending on email address: " + notification.getMessage()));
        notificationManager.registerHandler("sms",
                notification -> System.out.println("Sending sms: " + notification.getMessage()));
        notificationManager.registerHandler("push",
                notification -> System.out.println("Sending push-notification: " + notification.getMessage()));

        Notification emailNotification =
                new Notification("email", "Your email account has been successfully activated");
        Notification smsNotification = new Notification("sms", "You has been successfully changed password");
        Notification pushNotification = new Notification("push", "New post from user: Alice");
        notificationManager.sendMessage(emailNotification);
        notificationManager.sendMessage(smsNotification);
        notificationManager.sendMessage(pushNotification);
    }
}
