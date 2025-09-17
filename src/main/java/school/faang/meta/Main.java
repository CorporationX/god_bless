package school.faang.meta;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 * Дата: 17.09.2025
 * Описание: система, позволяющая пользователям
 * выбирать различные типы оповещений на основе
 * их предпочтений.
 */

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.printf("\nEmail: %s", notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS, notification ->
                System.out.printf("\nSMS: %s", notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH, notification ->
                System.out.printf("\nPush notification: %s", notification.getMessage()));

        notificationManager.addFilter(
                notification -> !notification.getMessage().toLowerCase().contains("взломан")
        );

        notificationManager.addCorrector(
                notification -> {
                    notification.setMessage(notification.getMessage() + " — FAANG School.");
                    return  notification;
                }
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваша почта подтверждена");
        Notification smsNotification = new Notification(NotificationType.SMS, "У вас новое сообщение!");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Ваш пароль изменен");
        Notification badNotification = new Notification(NotificationType.SMS, "Ваш аккаунт взломан!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(badNotification);
    }
}