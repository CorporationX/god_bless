package school.faang.metauniverse;

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
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.TELEGRAM_MESSAGE,
                notification -> {
                    String messenger = new String(notification.getType().toString().split("_")[0]);
                    System.out.printf("Message from %s: %s", messenger, notification.getMessage());
                }
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification telegramNotification = new Notification(NotificationType.TELEGRAM_MESSAGE,
                "Добро пожаловать на буткемп!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(telegramNotification);
    }
}
