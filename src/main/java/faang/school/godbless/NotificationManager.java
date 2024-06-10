package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> directionAndMessage = new HashMap<>();

    public void registerHandler(String message, Consumer<Notification> consumer) {
        directionAndMessage.put(message, consumer);
    }

    public void sendNotification(Notification notification) {
        directionAndMessage.get(notification.getType()).accept(notification);
    }
}