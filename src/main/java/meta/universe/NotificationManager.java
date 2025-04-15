package meta.universe;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Getter
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notifyAndHandlers = new HashMap<>();
    private final List<Predicate<Notification>> filterBadWords = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (Objects.isNull(type) || Objects.isNull(handler)) {
            throw new IllegalArgumentException("Please use non null parameters!");
        }
        notifyAndHandlers.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (Objects.isNull(notification)) {
            throw new IllegalArgumentException("Please use non null parameter!");
        } else if (!notifyAndHandlers.containsKey(notification.getType())) {
            throw new IllegalArgumentException("This notification type doesn t exist!");
        } else if (notifyAndHandlers.get(notification.getType()) == null) {
            throw new IllegalArgumentException("Notification for this type doesn t exist!");
        }

        if (checkBadWords(notification)) {
            notifyAndHandlers.get(notification.getType()).accept(notification);
        }
    }

    public void addFilter(Predicate<Notification> filter) {
        if (Objects.isNull(filter)) {
            throw new IllegalArgumentException("Please use non null parameter!");
        }
        filterBadWords.add(filter);
    }

    public boolean checkBadWords(Notification notification) {
        if (Objects.isNull(notification)) {
            throw new IllegalArgumentException("Please use non null parameter!");
        }
        for (Predicate<Notification> filter : filterBadWords) {
            if (filter.test(notification)) {
                return false;
            }
        }
        return true;
    }
}
