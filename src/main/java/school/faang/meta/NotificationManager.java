package school.faang.meta;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
@Data
public class NotificationManager {

    private Map<String, Consumer<Notification>> notificationIdsHandlers = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> notificationConsumer) {
        notificationIdsHandlers.put(id, notificationConsumer);
    }
    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = notificationIdsHandlers.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}
