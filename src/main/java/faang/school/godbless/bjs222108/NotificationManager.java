package faang.school.godbless.bjs222108;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationHandler) {
        this.notificationHandlers.put(type, notificationHandler);
    }

    public void sendNotification(Notification notification) {
        notificationHandlers.get(notification.getType()).accept(notification);
    }
}