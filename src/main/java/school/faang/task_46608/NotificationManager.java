package school.faang.task_46608;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@RequiredArgsConstructor
public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlersByType = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> handlersByFilter = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlersByType.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (handlersByType.get(notification.getType()) == null) {
            throw new IllegalArgumentException("Handler doesn't exist for notification with type: "
                    + notification.getType());
        }
        handlersByType.get(notification.getType()).accept(notification);
    }

    public void addFilter(String filter, Function<Notification, Notification> handler) {
        handlersByFilter.put(filter, handler);
    }

    public Notification filterNotification(String inputFilter, Notification notification) {
        Function<Notification, Notification> filter = handlersByFilter.get(inputFilter);
        if (filter != null) {
            System.out.println("Filtering...");
            return filter.apply(notification);
        }
        throw new IllegalArgumentException("This filter doesn't exist: " + inputFilter);
    }
}