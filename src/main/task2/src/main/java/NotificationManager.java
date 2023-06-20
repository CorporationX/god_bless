import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        handlers.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (!handlers.isEmpty() || handlers.containsKey(notification.type())) {
            Consumer<Notification> consumer = handlers.get(notification.type());
            consumer.accept(notification);
        } else {
            System.out.println("Map is empty or key doesn't exist");
            throw new IllegalArgumentException();

        }

    }
}
