package school.faang.bjs2_70663.meta_universe;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_70663.meta_universe.exception.HandlerNotFoundException;
import school.faang.bjs2_70663.meta_universe.exception.SensorshipNotPassedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private static final String HANDLER_NOT_FOUND = "Handler for type {} is not found";
    private static final String SENSOR_NOT_PASSED = "Sensorship for message {{}} is not passed";

    private final Map<NotificationType, Consumer<Notification>> notificationsMap = new HashMap<>();
    private Function<Notification, Notification> footer;
    private final List<Predicate<Notification>> filterList = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationsMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (filterList.stream()
                .anyMatch(filter -> filter.test(notification))) {
            log.error(SENSOR_NOT_PASSED, notification.getMessage());
            throw new SensorshipNotPassedException(SENSOR_NOT_PASSED, notification.getMessage());
        }
        if (footer != null) {
            footer.apply(notification);
        }
        Consumer<Notification> handler = notificationsMap.get(notification.getNotificationType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            log.error(HANDLER_NOT_FOUND, notification.getNotificationType());
            throw new HandlerNotFoundException(HANDLER_NOT_FOUND, notification.getNotificationType());
        }
    }

    public void addFooterHandler(Function<Notification, Notification> header) {
        this.footer = header;
    }

    public void addFilter(Predicate<Notification> filter) {
        filterList.add(filter);
    }

}
