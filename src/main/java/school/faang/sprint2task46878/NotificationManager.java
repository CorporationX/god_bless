package school.faang.sprint2task46878;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        map.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = map.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}