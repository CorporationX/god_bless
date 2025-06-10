package school.faang.bjs2_80553;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> processorMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        processorMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        processorMap.get(notification.getType()).accept(notification);
    }

}
