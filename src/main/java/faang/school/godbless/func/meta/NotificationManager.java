package faang.school.godbless.func.meta;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@NoArgsConstructor
public class NotificationManager {

    private final Map<String, Function<Notification, Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String type, Function<Notification, Notification> handler) {
        this.notificationHandlers.put(type, handler);
    }

    public Notification sendNotification(Notification notification) {
        var handler = notificationHandlers.get(notification.getType());
        if (handler != null) {
            return handler.apply(notification);
        }
        return null;
    }
}
