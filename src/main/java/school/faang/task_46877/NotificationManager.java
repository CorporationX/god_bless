package school.faang.task_46877;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
@Setter
public class NotificationManager {
    private Map<String, Consumer<Notification>> consumerMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        consumerMap.putIfAbsent(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = consumerMap.get(notification.getType());
        if (consumer != null) {
            consumer.accept(notification);
        } else {
            System.out.printf("Обработчик для типа '%s' не зарегистрирован.%n", notification.getType());
        }
    }
}
