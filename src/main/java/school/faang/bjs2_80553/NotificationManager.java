package school.faang.bjs2_80553;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> processorMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        processorMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        processorMap.get(notification.getType()).accept(notification);
    }

    //TODO: Filtering messages - architecture, code
    public boolean filterMessage(Notification notification, Predicate<Notification> filter) {
        return filter.test(notification);
    }

}
