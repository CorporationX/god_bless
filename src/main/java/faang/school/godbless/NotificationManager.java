package src.main.java.faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {
    private final Map<String, Consumer<Notification>>map = new HashMap<>();

    public void registerHandler(String type,Consumer<Notification> handler){
        map.put(type,handler);
    }
    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = map.get(notification.getType());
            handler.accept(notification);
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}