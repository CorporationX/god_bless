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
        configMap.getOrDefault(notification.getType(),
                n -> System.err.printf("Unregistered notification type '%s' request with message: %s\n",
                        n.getType(), n.getMessage()))
                .accept(notification);
    }

    public NotificationManager() {
        this.configMap = new HashMap<>();
    }
}
