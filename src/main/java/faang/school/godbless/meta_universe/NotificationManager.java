package faang.school.godbless.meta_universe;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class NotificationManager {

    private Map<String, Consumer<Notification>> notificationsMap = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationHandler) {
        notificationsMap.put(notificationType, notificationHandler);
    }

    public void sendNotification(Notification notification) {
        if (!checkForHandler(notification)) {
            throw new IllegalArgumentException("Notification dispatch unsuccessful. " +
                    "Please ensure the notification type is registered.");
        }
        notificationsMap.get(notification.getType()).accept(notification);
    }

    private boolean checkForHandler(Notification notification) {
        return notificationsMap.containsKey(notification.getType());
    }
}
