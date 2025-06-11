package school.faang.meta;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.println("Email: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS, notification ->
                System.out.println("SMS: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH, notification ->
                System.out.println("PUSH: " + notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован!");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен!");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Получено новое сообщение!");

        List<String> badWordList = List.of("Срань!", "Какаха!", "Жупел!");


        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.filterNotification(emailNotification, notification ->
                badWordList.contains(emailNotification.getMessage().toLowerCase()));

        notificationManager.addTextToNotification("from FAANG SCHOOL");
    }

}
