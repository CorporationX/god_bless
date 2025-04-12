package school.faang.lambda.meta_universe;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        // Отправка оповещений
        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.registerChecker(notification -> notification.getMessage().contains("*"));
        Notification censorNotification = new Notification(NotificationType.EMAIL,
                "*******");
        notificationManager.checkNotificationMessage(censorNotification);

        notificationManager.registerSignWriter(notification -> new Notification(notification.getType(),
                notification.getMessage() + " - From Me"));

        emailNotification = notificationManager.fillSender(emailNotification);
        notificationManager.sendNotification(emailNotification);
    }
}
