package school.faang.task_57967;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification " + notification.getMessage())
        );

        notificationManager.setFilter(notification -> !notification.getMessage().contains("bad word"));

        notificationManager.setCorrector(notification -> new Notification(notification.getType(),
                "Meta: " + notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification testFilterPushNotification = new Notification(NotificationType.PUSH, "В этом сообщение bad word.");

        try {
            notificationManager.sendNotification(emailNotification);
            notificationManager.sendNotification(smsNotification);
            notificationManager.sendNotification(pushNotification);
            notificationManager.sendNotification(testFilterPushNotification);
        } catch (IllegalArgumentException e) {
            System.out.println(testFilterPushNotification.getType() + " " + e.getMessage());
        }
    }
}
