package school.faang.universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();
    private final Map<String, Function<String, String>> mappers = new HashMap<>();

    public void addMapper(String source, Function<String, String> action) {
        mappers.computeIfAbsent(source, k -> action);
    }

    public void registerHandler(String id, Consumer<Notification> action) {
        notificationHandlers.computeIfAbsent(id, k -> action);
    }

    public boolean sendNotification(Notification notification) {
        Consumer<Notification> action = notificationHandlers.get(notification.getType());
        if (action != null) {
            Notification result = analyze(notification);
            action.accept(result);
            return true;
        }
        return false;
    }

    private Notification analyze(Notification notification) {
        String message = notification.getMessage();
        if (message == null) {
            return notification;
        }

        String[] splited = message.split(" ");

        for (String s : splited) {
            var action = mappers.get(s.toLowerCase());
            if (action != null) {
                message = action.apply(message);
            }
        }

        return new Notification(notification.getType(), message);
    }
}
