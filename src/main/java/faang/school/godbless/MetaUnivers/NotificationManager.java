package faang.school.godbless.MetaUnivers;

import lombok.AllArgsConstructor;
import lombok.ToString;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@ToString
public class NotificationManager {

    private final Map<String, Consumer<Notification>> ID_NOTIFICATION_MAP = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        ID_NOTIFICATION_MAP.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        ID_NOTIFICATION_MAP.get(notification.getType()).accept(notification);
    }
}
