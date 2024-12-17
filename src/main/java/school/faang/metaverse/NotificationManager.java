package school.faang.metaverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String identificator, Consumer<Notification> consumer) {
        map.put(identificator, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = map.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler found for notification type: " + notification.getType());
        }
    }
}
