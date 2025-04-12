package school.faang.meta;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlersMap = new HashMap<>();
    private final Map<NotificationType, List<Predicate<Notification>>> filtersMap = new HashMap<>();
    private final List<String> errors = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        this.notificationHandlersMap.put(type, handler);
    }

    public void registerFilter(NotificationType type, Predicate<Notification> filter) {
        this.filtersMap.computeIfAbsent(type, notificationType -> new ArrayList<>()).add(filter);
    }

    public void sendNotification(Notification notification) {
        boolean isValidationPassed = validateNotification(notification);
        if (isValidationPassed) {
            this.notificationHandlersMap.get(notification.getType()).accept(notification);
        }
    }

    public boolean validateNotification(Notification notification) {
        List<Predicate<Notification>> filters = this.filtersMap.computeIfAbsent(notification.getType(), notificationType -> new ArrayList<>());
        return filters.stream().allMatch(filter -> {
            if (!filter.test(notification)) {
                errors.add("filtering not passed for notification: " + notification);
                log.warn("filtering not passed for notification: {}", notification);
            }
            return filter.test(notification);
        });
    }

    public List<String> getErrors() {
        return errors;
    }
}
