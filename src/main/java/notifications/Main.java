package notifications;

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
                notification -> System.out.println("Push: " + notification.getMessage())
        );

        notificationManager.setFilter(notification -> notification.getMessage().contains("*нецензурная лексика*"));

        notificationManager.setMessageCorrector(notification -> {
            String correctedMessage = notification.getMessage() + " - Meta Team.";
            notification.setMessage(correctedMessage);
            return notification;
        });

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован!");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен!");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification blockedNotification = new Notification(NotificationType.SMS, "*нецензурная лексика*");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(blockedNotification);
    }
}
