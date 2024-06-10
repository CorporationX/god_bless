package faang.school.godbless.func.meta;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@NoArgsConstructor
public class NotificationManager {

    private final Map<String, Function<Notification, ?>> notificationHandlers = new HashMap<>();

    public void registerHandler(String type, Function<Notification, ?> handler) {
        this.notificationHandlers.put(type, handler);
    }

    @SuppressWarnings("unchecked")
    public <N> N sendNotification(Notification notification) {
        Function<Notification, ?> handler = notificationHandlers.get(notification.type());
        if (handler != null) {
            return (N) handler.apply(notification);
        }
        return null;
    }
}
