package school.faang.meta_universe;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.message()));

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.message()));

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.message()));

        // Фильтр: блокировать уведомления, содержащие "badword"
        notificationManager.setFilter(notification ->
                !notification.message().toLowerCase().contains("badword")
        );

        // Корректор: добавляет "[Meta Notification]" к сообщению
        notificationManager.setCorrector(notification ->
                new Notification(notification.type(), notification.message() + " [Meta Notification]")
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification badNotification = new Notification(NotificationType.EMAIL, "This contains badword");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(badNotification);
    }
}

