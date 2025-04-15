package gratsio_bjs2_70575;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage()));

        notificationManager.addFilter(notification -> !notification.getMessage().toLowerCase().contains("badword"));

        notificationManager.addMessageCorrector(notification -> new Notification(notification.getType(), notification.getMessage() + " Vermilion Company"));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account is activated");
        Notification smsNotification = new Notification(NotificationType.SMS, "Confirmation code: ХХХ");
        Notification pushNotification = new Notification(NotificationType.PUSH, "You have received a new message!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
