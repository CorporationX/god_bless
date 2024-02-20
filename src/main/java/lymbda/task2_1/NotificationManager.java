package lymbda.task2_1;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        Consumer<Notification> consumer = handlers.get(type);
        if (consumer != null) {
            consumer.accept(notification);
        }
    }
}
