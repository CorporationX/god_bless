package Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public static void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public static void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        }
    }
}