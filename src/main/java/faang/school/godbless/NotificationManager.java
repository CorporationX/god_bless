package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
@AllArgsConstructor
class Notification {
    private String type;
    private String message;
}

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();

    void registerHandler(String type, Consumer<Notification> consumer) {
        map.put(type, consumer);
    }

    void sendNotification(Notification notification) {
        map.get(notification.getType()).accept(notification);
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}