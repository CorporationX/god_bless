package school.faang.bjs2_87800;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerProcessor(NotificationType.EMAIL,
                notification -> new Notification(notification.getType(), notification.getMessage() + " - Meta Inc."));

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.registerFilter(NotificationType.EMAIL,
                notification -> !notification.getMessage().contains("плохое_слово"));

        Notification badEmailNotification = new Notification(NotificationType.EMAIL, "Содержит плохое_слово");
        notificationManager.sendNotification(badEmailNotification);
    }
}
