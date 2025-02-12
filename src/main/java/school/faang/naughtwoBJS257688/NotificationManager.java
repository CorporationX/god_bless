package school.faang.naughtwoBJS257688;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@NoArgsConstructor
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> handlersMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (!handlersMap.containsKey(type)) {
            handlersMap.put(type, handler);
            System.out.printf("Handler for type '%s' exists.%n", type);
        } else {
            System.out.printf("Handler for type '%s' already exists.%n", type);
        }
    }

    public void sendNotification(Notification notification) {
        NotificationType type = notification.getType();
        if (!handlersMap.containsKey(type)) {
            System.out.printf("Handler for type '%s' not exist.%n", type);
        } else {
            Consumer<Notification> handler = handlersMap.get(type);
            handler.accept(notification);
        }
    }
}
