package school.faang.metauniverse;

import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class NotificationManager {

    private static final Logger logger = LoggerFactory.getLogger(NotificationManager.class);

    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    @Setter
    private Function<Notification, Notification> corrector;
    private final List<Predicate<Notification>> filters = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            logger.error("Notification is null {}", notification);
            return;
        }
        for (Predicate<Notification> filter : filters) {
            if (filter.test(notification)) {
                logger.warn("Сообщение заблокировано! {}", notification);
                return;
            }
        }
        notification = corrector.apply(notification);
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            logger.warn("Такого типа отправки уведомлений не существует! {}", notification);
        }
    }

    public void addFilters(Predicate<Notification> filter) {
        if (!filters.contains(filter)) {
            filters.add(filter);
        }
    }
}
