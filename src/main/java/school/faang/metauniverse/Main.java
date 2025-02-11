package school.faang.metauniverse;

public class Main {
    public static void main(String[] args) {
        try {
            NotificationManager notificationManager = new NotificationManager();

            notificationManager.registerHandler(NotificationType.EMAIL,
                    notification -> System.out.println("Email: " + notification.getMessage()));
            notificationManager.registerHandler(NotificationType.SMS,
                    notification -> System.out.println("SMS: " + notification.getMessage()));
            notificationManager.registerHandler(NotificationType.PUSH,
                    notification -> System.out.println("Push Notification: " + notification.getMessage()));

            Notification emailNotification = new Notification(NotificationType.EMAIL,
                    "Ваш аккаунт активирован");
            Notification smsNotification = new Notification(NotificationType.SMS,
                    "Ваш пароль изменен");
            Notification firstPushNotification = new Notification(NotificationType.PUSH,
                    "У вас новое сообщение!");
            Notification secondPushNotification = new Notification(NotificationType.PUSH,
                    "Кому то понравилась ваша фотография");
            Notification thirdPushNotification = new Notification(NotificationType.PUSH,
                    "Максиму понравилась ваша фотография");

            notificationManager.sendNotification(emailNotification);
            notificationManager.sendNotification(smsNotification);
            notificationManager.sendNotification(firstPushNotification);
            notificationManager.sendNotification(secondPushNotification);

            notificationManager.updateNotification(secondPushNotification,
                    notification -> thirdPushNotification);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
