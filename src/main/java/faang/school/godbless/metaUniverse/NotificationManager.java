package faang.school.godbless.metaUniverse;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notifications.get(notification.getType()) == null) {
            System.out.println("type not found");
        } else {
            notifications.get(notification.getType()).accept(notification);
        }
    }
}