package faang.school.godbless.meta_universe;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@AllArgsConstructor
public class NotificationManager {
    private Map<String, Consumer<Notification>> handler;

    public void registerHandler(String typeNotification, Consumer<Notification> getMessage) {
        handler.put(typeNotification, getMessage);
    }

    public void sendNotification(Notification notification) {
        handler.get(notification.getType()).accept(notification);
    }

    public static void main(String[] args) {
        Map<String, Consumer<Notification>> handler = new HashMap<>();

        NotificationManager notificationManager = new NotificationManager(handler);

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
