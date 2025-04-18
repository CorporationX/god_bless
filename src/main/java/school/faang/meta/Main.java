package school.faang.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        notificationManager.sendNotification(emailNotification);
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        notificationManager.sendNotification(smsNotification);
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        notificationManager.sendNotification(pushNotification);

        Notification badEmailNotification = new Notification(NotificationType.EMAIL, "Kill yourself!");
        notificationManager.sendNotification(badEmailNotification);
        Notification badSmsNotification = new Notification(NotificationType.SMS, "I hope you will die!");
        notificationManager.sendNotification(badSmsNotification);
        Notification badPushNotification = new Notification(NotificationType.PUSH, "What a noob?!");
        notificationManager.sendNotification(badPushNotification);
    }
}
