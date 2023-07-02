package faang.school.godbless.metaverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    public Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> consumer) {
        notificationMap.put(notificationType, consumer);
    }

    public void sendNotification(Notification notification) {
        notificationMap.get(notification.getType()).accept(notification);
    }

    public Notification markNotification(Notification notification, Function<Notification, Notification> markImportantNotification) {
        return markImportantNotification.apply(notification);
    }
}
