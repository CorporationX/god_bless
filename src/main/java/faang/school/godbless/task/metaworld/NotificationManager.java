package faang.school.godbless.task.metaworld;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> messageHandler;

    public NotificationManager() {
        messageHandler = new HashMap<>();
    }

    public void registerHandler(String message, Consumer<Notification> consumer) {
        messageHandler.put(message, consumer);
    }

    public void sendNotification(Notification notification) {
        Optional.ofNullable(
                        messageHandler.get(notification.getType())
                )
                .orElseThrow(() -> new NoSuchElementException("Have no notification type: " + notification.getType()))
                .accept(notification);
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
