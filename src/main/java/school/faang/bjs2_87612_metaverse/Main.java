package school.faang.bjs2_87612_metaverse;

public class Main {
    @SuppressWarnings("checkstyle:WhitespaceAround")
    public static void main(String[] args) {
        var notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push: " + notification.getMessage()));

        var email = new Notification(NotificationType.EMAIL, "Текст для отправки по Email");
        var sms = new Notification(NotificationType.SMS, "Текст для отправки по SMS");
        var push = new Notification(NotificationType.PUSH, "Текст для отправки через Push");

        notificationManager.sendNotification(email);
        notificationManager.sendNotification(sms);
        notificationManager.sendNotification(push);

        System.out.println("\n--- Тестируем обработчик по умолчанию ---");
        var telegram = new Notification(NotificationType.TELEGRAM, "Это не должно сработать");
        notificationManager.sendNotification(telegram);
    }
}