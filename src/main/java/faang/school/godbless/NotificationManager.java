package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notice) {
        notificationMap.put(type, notice);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notice = notificationMap.get(notification.getType());
        notice.accept(notification);
    }
}
