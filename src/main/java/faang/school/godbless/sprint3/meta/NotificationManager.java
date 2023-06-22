package faang.school.godbless.sprint3.meta;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public class NotificationManager {
    private Map<String, Consumer<Notification>> handlerMap;
    private Map<String, Predicate<String>> filterMap;

    public NotificationManager() {
        handlerMap = new HashMap<>();
        filterMap = new HashMap<>();
    }

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlerMap.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        handlerMap.get(notification.getType()).accept(notification);
    }

    public void registerFilter(String notificationType, Predicate<String> filter) {
        filterMap.put(notificationType, filter);
    }

    public void filter(Notification notification, Function<String, String> function) {
        if (filterMap.get(notification.getType()).test(notification.getMessage())) {
            notification.setMessage(function.apply(notification.getMessage()));
        }
    }
}
