package meta.universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationsMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        notificationsMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notificationsMap.containsKey(notification.getType())) {
            Consumer<Notification> consumer = notificationsMap.get(notification.getType());
            consumer.accept(notification);
        } else {
            throw new IllegalArgumentException("Уведомления типа " + notification.getType() + " не поддерживаются");
        }
    }
}
