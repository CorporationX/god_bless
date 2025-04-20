package school.faang.meta;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private final List<Function<Notification, Notification>> correctors = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        this.handlers.put(type, handler);
    }

    public void registerFilter(Predicate<Notification> filter) {
        this.filters.add(filter);
    }

    public void registerCorrector(Function<Notification, Notification> corrector) {
        this.correctors.add(corrector);
    }

    public void sendNotification(Notification notification) {
        for (Predicate<Notification> filter : this.filters) {
            if (!filter.test(notification)) {
                log.info("Notification blocked due to invalid content: {}", notification.getMessage());
                return;
            }
            Notification correctedNotification = notification;
            for (Function<Notification, Notification> corrector : this.correctors) {
                correctedNotification = corrector.apply(correctedNotification);
            }
            Consumer<Notification> handler = this.handlers.get(correctedNotification.getType());
            if (handler != null) {
                handler.accept(correctedNotification);
            } else {
                log.info("No handler found for notification type: {}", notification.getType());
            }
        }
    }
}
