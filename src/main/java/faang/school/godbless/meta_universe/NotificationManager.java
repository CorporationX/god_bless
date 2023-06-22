package faang.school.godbless.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private static Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public static void registerHandler(String messageType, Consumer<Notification> handler) {
        handlers.put(messageType, handler);
    }

    public static void sendNotification(Notification notification) {
        handlers.get(notification.getType()).accept(notification);
    }
}