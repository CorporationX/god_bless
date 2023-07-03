package faang.school.godbless.sprint3.lambda.task8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Сообщение не может быть пустым!");
        }
        handlers.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification не может быть null");
        }
        Consumer<Notification> notificationConsumer = handlers.get(notification.getType());
        notificationConsumer.accept(notification);
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHandler(null, (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
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
