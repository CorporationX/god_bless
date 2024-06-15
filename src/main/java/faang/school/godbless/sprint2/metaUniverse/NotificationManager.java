package faang.school.godbless.sprint2.metaUniverse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@Data
@AllArgsConstructor
public class NotificationManager {

    private final Map<String, Consumer<Notification>> notifications;
    private final Map<String, Function<Notification, Notification>> filters;

    public NotificationManager() {
        notifications = new HashMap<>();
        filters = new HashMap<>();
    }

    public void registerHandler(String identificatorOfNotification, Consumer<Notification> notificationConsumer) {
        if (!isValidIdentificatorOfNotification(identificatorOfNotification)) {
            throw new IllegalArgumentException("Incorrect identificator of notification");
        }

        notifications.put(identificatorOfNotification, notificationConsumer);
    }

    public void registerFilter(String filterName, Function<Notification, Notification> notificationFunction) {
        if (!isValidFilterName(filterName)) {
            throw new IllegalArgumentException("Incorrect filter name");
        }

        filters.put(filterName, notificationFunction);
    }

    public void sendNotification(Notification notification) {
        if (!isValidNotification(notification)) {
            throw new IllegalArgumentException("Incorrect notification");
        }

        Function<Notification, Notification> badWords = filters.get("badWords");

        Notification filteredNotification = (badWords != null) ? badWords.apply(notification) : notification;

        if (filteredNotification == null) {
            throw new IllegalArgumentException("Message contains bad words");
        }

        Consumer<Notification> notificationConsumer = notifications.get(notification.getType());

        if (notificationConsumer != null) {
            notificationConsumer.accept(notification);
        }
    }

    private boolean isValidIdentificatorOfNotification(String identificatorOfNotification) {
        return identificatorOfNotification != null && !identificatorOfNotification.isEmpty();
    }

    private boolean isValidFilterName(String isValidFilterName) {
        return isValidFilterName != null && !isValidFilterName.isEmpty();
    }

    private boolean isValidNotification(Notification notification) {
        return notification != null && (notification.getMessage() != null && !notification.getMessage().isEmpty())
                && (notification.getType() != null && !notification.getType().isEmpty());
    }
}
