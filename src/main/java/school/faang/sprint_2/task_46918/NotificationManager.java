package school.faang.sprint_2.task_46918;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@ToString
public class NotificationManager {
    private final Map<String, Consumer<Notification>> stringConsumerMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        if (type != null && consumer != null) {
            stringConsumerMap.put(type, consumer);
        } else {
            System.out.println("Тип оповещения или само оповещение не должно быть Null");
        }
    }

    public void sendNotification(Notification notification) {
        if (stringConsumerMap.containsKey(notification.getType())) {
            stringConsumerMap.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Такого типа оповещения нет");
        }
    }
}
