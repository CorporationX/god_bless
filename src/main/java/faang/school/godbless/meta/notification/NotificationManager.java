package faang.school.godbless.meta.notification;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class NotificationManager {

    private final Map<String, Consumer<Notification>> handlersMap = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> notification) {
        handlersMap.put(notificationId, notification);
    }

    void sendNotification(Notification notification) {
        String notificationType = notification.getType();
        if (handlersMap.containsKey(notificationType)) {
            handlersMap.get(notificationType).accept(notification);
        }
    }
}
