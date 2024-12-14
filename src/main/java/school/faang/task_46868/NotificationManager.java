package school.faang.task_46868;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Handler for type '" + notification.getType() + "' not specified.");
        }
    }

    public void applyFilter(Function<String, String> filter, Notification notification) {
        String filteredMessage = filter.apply(notification.getMessage());
        notification.setMessage(filteredMessage);
    }
}
