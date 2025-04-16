package school.faang.stream2.metauniverse;

import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> configMap;

    public boolean registerHandler(NotificationType type, Consumer<Notification> handler) {
        return false;
    }

    public void sendNotification(Notification notification) {

    }
}
