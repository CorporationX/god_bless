package faang.school.godbless.mUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    Map<String, Consumer<Notification>> handlers = new HashMap<>();
    Map<String, Predicate<Notification>> filters = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        if (handlers.containsKey(type)) {
            handlers.get(type).accept(notification);
        } else {
            System.out.println("Оповещений такого типа нет.");
        }
    }

    public void checkNotificationType(String type, Predicate<Notification> handler) {
        filters.put(type, handler);
    }
}
