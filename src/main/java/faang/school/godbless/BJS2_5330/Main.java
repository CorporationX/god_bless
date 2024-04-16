package faang.school.godbless.BJS2_5330;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args){
        Map<String, Consumer<Notification>> handlers = new HashMap<>();
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) ->
                System.out.println("Отправка по электронной почте: " + notification.getMessage()), handlers);
        notificationManager.registerHandler("sms", (notification) ->
                System.out.println("Отправка SMS: " + notification.getMessage()), handlers);
        notificationManager.registerHandler("push", (notification) ->
                System.out.println("Отправка push-уведомления: " + notification.getMessage()), handlers);

        Notification emailNotification = new Notification("email!!!!", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification, handlers);
        notificationManager.sendNotification(smsNotification, handlers);
        notificationManager.sendNotification(pushNotification, handlers);
    }
}
