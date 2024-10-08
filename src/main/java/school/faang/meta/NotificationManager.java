package school.faang.meta;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
@Data
public class NotificationManager {

    public Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> notificationConsumer) {
        notificationMap.put(id, notificationConsumer);
    }
    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = notificationMap.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}
