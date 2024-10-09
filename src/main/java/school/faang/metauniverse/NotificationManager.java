package school.faang.metauniverse;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
@Setter
public class NotificationManager {

    private Map<String, Consumer<Notification>> notificationTypeToHandler = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        notificationTypeToHandler.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        if (notificationTypeToHandler.containsKey(notification.getType())) {
            notificationTypeToHandler.get(notification.getType()).accept(notification);
        }
    }
}
