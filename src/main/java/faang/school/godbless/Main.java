package src.main.java.faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = getNotificationManager();

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        Map<String, Predicate<Notification>> filter = new HashMap<>();
        filter.put("filtration", notification -> false);
    }

    private static NotificationManager getNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) ->
            System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) ->
            System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) ->
                System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        return notificationManager;
    }
}
