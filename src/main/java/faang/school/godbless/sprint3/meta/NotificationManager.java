package faang.school.godbless.sprint3.meta;

import java.util.Objects;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
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
       if (Objects.nonNull(handlerMap.get(notification.getType()))) {
            handlerMap.get(notification.getType()).accept(notification);
        } else {
           log.warn("No suitable handler");
       }
    }

    public void registerFilter(String notificationType, Predicate<String> filter) {
        filterMap.put(notificationType, filter);
    }

    public void filter(Notification notification, Function<String, String> function) {
        if (Objects.nonNull(filterMap.get(notification.getType()))) {
            if (filterMap.get(notification.getType()).test(notification.getMessage())) {
                notification.setMessage(function.apply(notification.getMessage()));
            }
        } else {
            log.warn("No suitable filter");
        }
    }
}
