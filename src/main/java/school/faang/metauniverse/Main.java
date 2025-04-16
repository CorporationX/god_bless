package school.faang.metauniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.TELEGRAM_MESSAGE,
                notification -> {
                    String messenger = new String(notification.getType().toString().split("_")[0]);
                    System.out.printf("Message from %s: %s", messenger, notification.getMessage());
                }
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account has been activated.");
        Notification smsNotification = new Notification(NotificationType.SMS, "Your password has been changed.");
        Notification pushNotification = new Notification(NotificationType.PUSH, "You've got new notification!");
        Notification telegramNotification = new Notification(NotificationType.TELEGRAM_MESSAGE,
                "Welcome to bootcamp!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(telegramNotification);
    }
}
