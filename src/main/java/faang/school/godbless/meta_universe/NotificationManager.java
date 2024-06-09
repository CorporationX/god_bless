package faang.school.godbless.meta_universe;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationsByType = new HashMap<>();

    public void registerHandler(@NonNull String type, @NonNull Consumer<Notification> notificationConsumer) {
        notificationsByType.put(type, notificationConsumer);
    }

    public void sendNotification(@NonNull Notification notification) {
        Consumer<Notification> notificationConsumer = notificationsByType.get(notification.getType());

        if (notificationConsumer == null) {
            throw new IllegalArgumentException("Notification type not found");
        }

        notificationConsumer.accept(notification);
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
