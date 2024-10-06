package school.BJS2_34611;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private Map<String, Consumer<Notification>> listeners = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        listeners.put(type, handler);
    }
    public void sendNotification(Notification notification) {
        String type = notification.getType();
        listeners.get(type).accept(notification);

    }


}
