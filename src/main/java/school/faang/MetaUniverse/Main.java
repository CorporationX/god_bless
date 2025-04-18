package school.faang.MetaUniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push: " + notification.getMessage())
        );

        // Добавление фильтра — блокировка спама
        notificationManager.addFilter(notification -> !notification.getMessage().toLowerCase().contains("спам"));

        // Добавление процессора — подпись компании
        notificationManager.addProcessor(notification ->
                new Notification(notification.getType(), notification.getMessage() + " [Meta Team]")
        );

        // Уведомления
        Notification email = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification sms = new Notification(NotificationType.SMS, "СПАМ: Получите миллион!");
        Notification push = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(email); // проходит
        notificationManager.sendNotification(sms);   // блокируется
        notificationManager.sendNotification(push);  // проходит
    }
}