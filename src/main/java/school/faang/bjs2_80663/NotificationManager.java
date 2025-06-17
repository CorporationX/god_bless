package school.faang.bjs2_80663;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.function.Consumer;

@AllArgsConstructor
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> noticitationsMap;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        noticitationsMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        noticitationsMap.get(notification.getNotificationType()).accept(notification);
    }
}
