package school.faang.BJS2_34751;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHendler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotifycation(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No handler for " + notification.getType());
        }
    }
}
