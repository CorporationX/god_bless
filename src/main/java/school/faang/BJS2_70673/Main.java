package school.faang.BJS2_70673;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.printf("Email: %s\n", notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.printf("SMS: %s\n", notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.printf("Push Notification: %s\n", notification.getMessage())
        );

        notificationManager.setFilter(notification -> !notification.getMessage().toLowerCase().contains("spam"));

        notificationManager.setMessageProcessor(notification ->
                new Notification(notification.getType(), notification.getMessage() + "\n- Meta Team")
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification spamNotification = new Notification(NotificationType.EMAIL, "Это spaM-сообщение");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(spamNotification);
    }
}