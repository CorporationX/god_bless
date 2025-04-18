package school.faang.metauniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.addHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );
        notificationManager.addHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );
        notificationManager.addHandler(NotificationType.PUSH,
                notification -> System.out.println("Push: " + notification.getMessage())
        );

        notificationManager.addFilter(notification -> !notification.getMessage().toLowerCase().contains("спам"));

        notificationManager.addProcessor(notification ->
                new Notification(notification.getType(), notification.getMessage() + " [Meta Team]")
        );

        Notification email = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification sms = new Notification(NotificationType.SMS, "СПАМ: Получите миллион!");
        Notification push = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(email);
        notificationManager.sendNotification(sms);
        notificationManager.sendNotification(push);
    }
}