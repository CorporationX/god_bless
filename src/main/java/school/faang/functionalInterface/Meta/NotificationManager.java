package school.faang.functionalInterface.Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> HANDLERS = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        HANDLERS.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        HANDLERS.getOrDefault(notification.getType(), s ->
                System.out.println("Notification " + notification.getType() + " is not registered")).accept(notification);
    }

}
