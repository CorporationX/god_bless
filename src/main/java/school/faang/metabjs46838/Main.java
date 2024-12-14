package school.faang.metabjs46838;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Send by email: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("Send by sms: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Send by push: " + notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL,
                "Your account has been successfully activated");
        Notification smsNotification = new Notification(NotificationType.SMS,
                "You have successfully changed your password");
        Notification pushNotification = new Notification(NotificationType.PUSH,
                "New post from user: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
