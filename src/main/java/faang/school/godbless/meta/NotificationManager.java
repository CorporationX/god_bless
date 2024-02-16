package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private static final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public static void registerHandler(String notificationType, Consumer<Notification> handler) {
        notificationHandlers.put(notificationType, handler );
    }

    public static void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationHandlers.get(notification.getType() );
        if (handler != null) {
            handler.accept(notification );
        }
    }

}
