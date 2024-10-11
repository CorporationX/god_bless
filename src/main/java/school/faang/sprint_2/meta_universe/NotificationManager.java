package school.faang.sprint_2.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> handlerMap = new HashMap<>();

    public void registerHandler(String identifier, Consumer<Notification> doNotification) {
        handlerMap.put(identifier, doNotification);
    }

    public void sendNotification(Notification notification) {
        String identifier = notification.type();

        handlerMap.get(identifier).accept(notification);
    }
}
