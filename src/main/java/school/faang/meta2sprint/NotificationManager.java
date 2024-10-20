package school.faang.meta2sprint;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        map.put(type, consumer);
    }

    public void sendNotification(Notification notificationObject) {
        Consumer<Notification> consumer = map.get(notificationObject.getType());
        if (consumer != null) {
            consumer.accept(notificationObject);
        }
    }
}

