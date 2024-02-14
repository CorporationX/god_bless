package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationMap = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> notification) {
        notificationMap.put(type, notification);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> type = notificationMap.get(notification.getType());
        if (type != null) {
            type.accept(notification);
        } else {
            throw new NoSuchElementException("There is no such type of notifications");
        }
    }
}
