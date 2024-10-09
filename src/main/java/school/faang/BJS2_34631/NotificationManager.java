package school.faang.BJS2_34631;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications;
    private final Map<String, Predicate<Notification>> censures;

    public NotificationManager() {
        this.notifications = new HashMap<>();
        this.censures = new HashMap<>();
    }

    public void registerHandler(String identification,
                                Consumer<Notification> notify) {
        notifications.put(identification, notify);
    }

    public void registerCensure(String filterName,
                                Predicate<Notification> filter) {
        censures.put(filterName, filter);
    }

    public void sendNotification(Notification notification) {
        if (censures.values().stream().anyMatch(c -> c.test(notification))) {
            System.err.println("Notification filtered by censure "
                    + notification.getMessage());
            return;
        }

        Optional.ofNullable(notifications.get(notification.getType()))
                .ifPresentOrElse(n -> n.accept(notification),
                        () -> System.err.println("No handler found for " +
                                "notification type " + notification.getType()));
    }
}
