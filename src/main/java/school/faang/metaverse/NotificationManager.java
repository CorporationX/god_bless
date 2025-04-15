package school.faang.metaverse;

import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * Related to JIRA ticket: BJS2-71883
 * */
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlersByType = new HashMap<>();
    private final Set<Predicate<Notification>> filters = new HashSet<>();
    @Setter
    private Function<Notification, Notification> corrector = Function.identity();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (handler == null || type == null) {
            throw new IllegalArgumentException("Type and handler must not be null!");
        }
        notificationHandlersByType.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification must not be null!");
        }
        applyFilters(notification);
        final Notification processNotification = applyCorrector(notification);

        Optional.ofNullable(notificationHandlersByType.get(processNotification.getType()))
                .ifPresentOrElse(
                        handler -> handler.accept(processNotification),
                        () -> System.out.printf("No handler registered for type %s!", processNotification.getType()));
    }

    public void addFilter(Predicate<Notification> filter) {
        if (filter == null) {
            throw new IllegalArgumentException("Filter must not be null!");
        } else if (filters.contains(filter)) {
            throw new IllegalArgumentException("Filter already in the list!");
        }
        filters.add(filter);
    }

    private void applyFilters(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification must not be null!");
        }
        filters.forEach(filter -> {
            if (!filter.test(notification)) {
                throw new IllegalStateException("Notification did not pass filter!");
            }
        });
    }

    private Notification applyCorrector(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification must not be null!");
        }
        return corrector.apply(notification);
    }
}
