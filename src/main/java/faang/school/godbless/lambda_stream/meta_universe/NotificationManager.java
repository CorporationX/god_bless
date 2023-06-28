package faang.school.godbless.lambda_stream.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private static Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private static Map<Predicate<Notification>, Function<Notification, Notification>> filters = new HashMap<>();

    public static void registerHandler(String messageType, Consumer<Notification> handler) {
        handlers.put(messageType, handler);
    }

    public static void sendNotification(Notification notification) {
        if (!handlers.containsKey(notification.getType())) {
            throw new RuntimeException("No handler for type: " + notification.getType());
        }
        handlers.get(notification.getType()).accept(notification);
    }

    public static void registerFilter(Predicate<Notification> testFilter,
                                      Function<Notification, Notification> applyFilter) {
        filters.put(testFilter, applyFilter);
    }

    public static Notification filterNotification(Notification notification) {
        for (Predicate<Notification> predicate : filters.keySet()) {
            if (predicate.test(notification)) {
                return filters.get(predicate).apply(notification);
            }
        }
        return notification;
    }
}