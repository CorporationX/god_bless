package school.faang.task_46907;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> consumer) {
        map.put(id, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = map.get(notification.getType());
        if (consumer != null) {
            consumer.accept(notification);
        } else {
            System.out.println("Не найден обработчик для типа уведомления: " + notification.getType());
        }
    }

}

