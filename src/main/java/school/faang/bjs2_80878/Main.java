package school.faang.bjs2_80878;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.addFilter(notification
                -> !notification.getMessage().toLowerCase().contains("пиво"));

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("Sms: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push: " + notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Попытка входа в аккаунт");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение");
        Notification badNotification = new Notification(NotificationType.PUSH, "У вас есть пиво");


        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(badNotification);

    }
}
