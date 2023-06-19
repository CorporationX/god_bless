package faang.school.godbless.sprint3.task8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String message, Consumer<Notification> consumer) {
        if (message == null) {
            throw new NullPointerException("Сообщение не может быть пустым!");
        }
        if (message.isBlank()) {
            throw new IllegalArgumentException("Сообщение не может быть пустым!");
        }
        map.put(message, consumer);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new NullPointerException("Notification не может быть null");
        }
        Consumer<Notification> notificationConsumer = map.get(notification.getType());
        notificationConsumer.accept(notification);
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

// Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
