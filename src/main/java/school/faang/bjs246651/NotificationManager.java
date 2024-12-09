package school.faang.bjs246651;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notification) {
        map.put(type, notification);
    }

    public void sendNotification(Notification notification) {
        map.get(notification.getType()).accept(notification);
    }

}
