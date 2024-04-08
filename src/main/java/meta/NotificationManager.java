package meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notification = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler){
        notification.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        this.notification.get(notification.getType()).accept(notification);
    }
}
