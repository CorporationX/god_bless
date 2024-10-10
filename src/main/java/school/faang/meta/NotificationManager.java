package school.faang.meta;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
@Data
public class NotificationManager {

    private Map<String, Consumer<Notification>> notificationIdHandlers = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> notificationConsumer) {
        notificationIdHandlers.put(id, notificationConsumer);
    }
    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = notificationIdHandlers.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}
