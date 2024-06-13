package faang.school.godbless.Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> processingNotification = new HashMap<>();

    void registerHandler(String type, Consumer<Notification> consumer) {
        processingNotification.put(type, consumer);
    }

    void sendNotification(Notification notification) {
        processingNotification.get(notification.getType()).accept(notification);
    }
}
