package school.faang.bjs2_87764;

public class Application {
    @SuppressWarnings("checkstyle:LineLength")
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

        notificationManager.registerFilter("SpamFilter", notification ->
                !notification.getMessage().toLowerCase().contains("спам")
                        && !notification.getMessage().toLowerCase().contains("casino")
        );

        notificationManager.registerFilter("LengthFilter", notification ->
                notification.getMessage().length() <= 100
        );

        notificationManager.registerEditor(notification ->
                new Notification(notification.getType(),
                        notification.getMessage() + " | Best regards, Company")
        );

        notificationManager.registerEditor(notification ->
                new Notification(notification.getType(),
                        "[Important] " + notification.getMessage())
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        System.out.println("\n=== Testing filters ===");
        Notification spamNotification = new Notification(NotificationType.EMAIL, "Вы выиграли в casino!");
        Notification longNotification = new Notification(NotificationType.SMS,
                "Это очень длинное сообщение, которое должно быть заблокировано фильтром длины, потому что оно превышает максимально");

        notificationManager.sendNotification(spamNotification);
        notificationManager.sendNotification(longNotification);
    }
}
