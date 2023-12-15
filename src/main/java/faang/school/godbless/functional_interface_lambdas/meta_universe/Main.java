package faang.school.godbless.functional_interface_lambdas.meta_universe;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        String email = "email";
        String sms = "sms";
        String push = "push";

        notificationManager.registerHandler(email, (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler(sms, (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler(push, (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        // Отправка оповещений
        Notification emailNotification = new Notification(email, "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(sms, "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(push, "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);


    }
}

class NotificationManager {
    private Map<String, Consumer<Notification>> map = new HashMap<>();

    void registerHandler(String type, Consumer<Notification> consumer) {
        map.put(type, consumer);
    }

    void sendNotification(Notification notification) {
        Consumer<Notification> consumer = map.get(notification.getType());
        if (consumer != null) {
            consumer.accept(notification);
        } else {
            System.out.println("Notification not found");
        }
    }
}


@Data
@AllArgsConstructor
class Notification {
    private String type;
    private String message;

}
