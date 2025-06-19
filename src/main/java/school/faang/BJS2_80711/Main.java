package school.faang.BJS2_80711;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("EMAIL: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("PUSH: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.IN_APP,
                notification -> System.out.println("IN-APP: " + notification.getMessage())
        );

        //Ограничение на сообщения больше 30 символов
        notificationManager.setFilter(
                notification -> notification.getMessage().length() <= 30
        );

        Notification emailNotification = new Notification(
                NotificationType.EMAIL,
                "Добро пожаловать в наше приложение!"
        );

        Notification emailNotificationLong = new Notification(
                NotificationType.EMAIL,
                "Добро пожаловать в наше приложение! Хотите увидеть как тут всё устроенно?"
        );

        Notification smsNotification = new Notification(
                NotificationType.SMS,
                "Ваш код подтверждения: 1234"
        );

        Notification pushNotification = new Notification(
                NotificationType.PUSH,
                "У вас 3 новых сообщения"
        );

        Notification inAppNotification = new Notification(
                NotificationType.IN_APP,
                "Привет! У вас 10 новых рекомендованных друзей! Хотите посмотреть?"
        );

        // Добавляем подпись ко всем сообщениям
        notificationManager.setMessageCorrector(
                notification ->
                new Notification(notification.getType(), notification.getMessage() + "\nС уважением, от меня)\n")
        );

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(emailNotificationLong);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(inAppNotification);
    }
}