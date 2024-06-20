package faang.school.godbless.metaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private Map<Predicate<Notification>, Function<Notification, Notification>> filters = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void registerFilter(Predicate<Notification> condition, Function<Notification, Notification> filter) {
        filters.put(condition, filter);
    }

    public void sendNotification(Notification notification) {
        for (Map.Entry<Predicate<Notification>, Function<Notification, Notification>> entry : filters.entrySet()) {
            if (entry.getKey().test(notification)) {
                notification = entry.getValue().apply(notification);
            }
        }

        Consumer<Notification> handler = handlers.get(notification.type);
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для типа оповещения: " + notification.type);
        }
    }
}
