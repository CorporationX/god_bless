package school.faang.bjs2_91650;

public class Main {
    public static void main(String[] args) {
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
        Notification pushNotification = new Notification(NotificationType.PUSH,
                "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.setFilter(
                notification -> !notification.getMessage().toLowerCase().contains("spam"));

        Notification goodNotification = new Notification(NotificationType.EMAIL,
                "Welcome to the platform!");
        Notification badNotification = new Notification(NotificationType.SMS,
                "This is spam");

        notificationManager.sendNotification(goodNotification);
        notificationManager.sendNotification(badNotification);
    }
}