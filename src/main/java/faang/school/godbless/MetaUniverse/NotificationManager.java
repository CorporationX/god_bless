package faang.school.godbless.MetaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationMap;

    public NotificationManager() {
        this.notificationMap = new HashMap<>();
    }

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
       notificationMap.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = notificationMap.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}
