package school.faang.Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> identifiers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        identifiers.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        String type = notification.type();
        Consumer<Notification> keymap = identifiers.get(type);
        keymap.accept(notification);
    }
}
