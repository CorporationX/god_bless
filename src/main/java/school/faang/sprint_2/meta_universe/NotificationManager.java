package school.faang.sprint_2.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String identifier, Consumer<Notification> doNotification) {
        notificationMap.put(identifier, doNotification);
    }

    public void sendNotification(Notification notification) {
        String identifier = notification.type();

        notificationMap.get(identifier).accept(notification);
    }
}
