package school.faang.meta.notification;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class NotificationFilter {
    private final Map<NotificationType, List<Predicate<Notification>>> filters = new EnumMap<>(NotificationType.class);

    public void addFilter(NotificationType type, Predicate<Notification> filter) {
        filters.computeIfAbsent(type, k -> new ArrayList<>()).add(filter);
    }

    public boolean applyFilters(Notification notification) {
        List<Predicate<Notification>> typeFilters = filters.get(notification.getType());
        if (typeFilters == null || typeFilters.isEmpty()) {
            return true;
        }
        return typeFilters.stream().allMatch(filter -> filter.test(notification));
    }
}
