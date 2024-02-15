package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationHandlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            throw new NoSuchElementException("There is no such type of notifications");
        }
    }
}
