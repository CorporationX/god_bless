package school.faang.task_59812;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.message()));
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.message()));
        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push: " + notification.message()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.setFilter(notification -> !notification.message().contains("Мат"));

        Notification blockedNotification = new Notification(NotificationType.EMAIL, "Мат");
        notificationManager.sendNotification(blockedNotification);

        notificationManager.setCorrector(notification ->
                new Notification(notification.type(), "[Компания] " + notification.message())
        );

        Notification correctedNotification = new Notification(NotificationType.EMAIL, "Email отправлен");
        notificationManager.sendNotification(correctedNotification);
    }
}
