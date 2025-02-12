package school.faang.sprint2.task_BJS2_57772;

public class Main {
    private static final NotificationManager NOTIFICATION_MANAGER = new NotificationManager();

    public static void main(String[] args) {
        registerNotificationType(NotificationType.EMAIL);
        registerNotificationType(NotificationType.SMS);
        registerNotificationType(NotificationType.PUSH);

        createAndSendNotification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        createAndSendNotification(NotificationType.SMS, "Ваш пароль изменен");
        createAndSendNotification(NotificationType.PUSH, "У вас новое сообщение!");
    }

    private static void registerNotificationType(NotificationType type) {
        NOTIFICATION_MANAGER.registerHandler(type,
                notification -> System.out.printf("%s %s\n", notification.getType(), notification.getMessage()));
    }

    private static void createAndSendNotification(NotificationType type, String msg) {
        Notification notification = new Notification(type, msg);
        NOTIFICATION_MANAGER.sendNotification(notification);
    }

}
