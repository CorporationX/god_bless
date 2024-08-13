package faang.school.godbless.lambda.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    public static final String NO_HANDLER_OUTPUT = "No handler registered for notificationId: ";

    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String notificationId, Consumer<Notification> handler) {
        handlers.put(notificationId, handler);
    }

    public void sendNotification(Notification notification) {
        String notificationId = notification.getId();
        handlers.getOrDefault(notificationId, n -> System.out.println(NO_HANDLER_OUTPUT + notificationId)).accept(notification);
    }
}
