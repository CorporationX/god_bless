package meta.universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlerMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notification) {
        handlerMap.put(type, notification);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlerMap.get(notification.getType());
        if (handler == null) {
            System.out.println("No handler for: " + notification.getType());
        } else {
            handler.accept(notification);
        }
    }
}
