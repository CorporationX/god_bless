package school.faang.meta;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        final List<String> badWordList = List.of("срань", "какаха", "жупел");

        notificationManager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.println("Email: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS, notification ->
                System.out.println("SMS: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH, notification ->
                System.out.println("PUSH: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SPAM, notification ->
                System.out.println("SPAM: " + notification.getMessage()));

        final Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован!");
        final Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен!");
        final Notification pushNotification = new Notification(NotificationType.PUSH, "Получено новое сообщение!");
        final Notification spamNotification = new Notification(NotificationType.SPAM, "Ты жупел!");

        if (notificationManager.filterNotification(spamNotification, notification ->
                badWordList.contains(spamNotification.getMessage().toLowerCase()))) {
            System.out.println("Сообщение заблокировано!");
        } else {
            notificationManager.sendNotification(spamNotification);
        }

        var emailWithTextAdded = notificationManager.addTextToNotification(emailNotification).apply(emailNotification);

        notificationManager.sendNotification(emailWithTextAdded);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }

}