package school.faang.stream2.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> configMap;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        configMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        configMap.get(notification.getType()).accept(notification);
    }

    public NotificationManager() {
        this.configMap = new HashMap<>();
    }
}
