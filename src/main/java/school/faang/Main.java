package school.faang;

public class Main {
    private static final NotificationManager NOTIFICATION_MANAGER = new NotificationManager();

    public static void main(String[] args) {
        for (NotificationType type : NotificationType.values()) {
            registerNotification((type));
        }

        sendNotification(NotificationType.SMS, "Код доступа 7765");
        sendNotification(NotificationType.EMAIL, "Скидки до 23%");
        sendNotification(NotificationType.PUSH, "Sent a reel by faangschool");
    }

    public static void registerNotification(NotificationType notificationType) {
        NOTIFICATION_MANAGER.registerHandler(notificationType,
                notification -> System.out.printf("%s: %s\n",
                        notification.getNotificationType(), notification.getMessage()));
    }

    public static void sendNotification(NotificationType notificationType, String message) {
        Notification notification = new Notification(notificationType, message);
        NOTIFICATION_MANAGER.sendNotification(notification);
    }
}
