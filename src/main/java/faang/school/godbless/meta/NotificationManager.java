package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    public Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        if (handlers.containsKey(type)) {
            Consumer<Notification> handler = handlers.get(type);
            handler.accept(notification);
        }
    }
}
