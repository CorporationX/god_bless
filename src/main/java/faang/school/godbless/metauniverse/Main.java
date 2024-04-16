package faang.school.godbless.metauniverse;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager(new HashMap<>());

        notificationManager.registerHandler("email", (notification) -> {
            String message = String.format("Отправка по электронной почте: %s", notification.getMessage());
            System.out.println(message);
        });
        notificationManager.registerHandler("sms", (notification) -> {
            String message = String.format("Отправка SMS: %s", notification.getMessage());
            System.out.println(message);
        });
        notificationManager.registerHandler("push", (notification) -> {
            String message = String.format("Отправка push-уведомления: %s", notification.getMessage());
            System.out.println(message);
        });

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
