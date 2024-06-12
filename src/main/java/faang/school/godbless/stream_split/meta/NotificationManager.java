package faang.school.godbless.stream_split.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private static final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        handlers.put(type, consumer);

    }

    public void sendNotification(Notification notification) {
        handlers.get(notification.type()).accept(notification);
    }
}