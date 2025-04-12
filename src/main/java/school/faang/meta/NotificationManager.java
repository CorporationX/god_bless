package school.faang.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlersMap = new HashMap<>();
    private final Map<NotificationType, List<Predicate<Notification>>> filtersMap = new HashMap<>();
    private final List<String> errors = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlersMap.put(type, handler);
    }

    public void registerFilter(NotificationType type, Predicate<Notification> filter) {
        List<Predicate<Notification>> filtersList = filtersMap.getOrDefault(type, new ArrayList<>());
        filtersList.add(filter);
        filtersMap.put(type, filtersList);
    }

    public void sendNotification(Notification notification) {
        boolean isValidationPassed = validateNotification(notification);
        if (isValidationPassed) {
            notificationHandlersMap.get(notification.getType()).accept(notification);
        }
    }

    public boolean validateNotification(Notification notification) {
        boolean isValidationPassed = true;
        List<Predicate<Notification>> filters = filtersMap.get(notification.getType());
        if (filters != null) {
            for (Predicate<Notification> filter : filters) {
                if (!filter.test(notification)) {
                    errors.add("filtering not passed for notification: " + notification);
                    isValidationPassed = false;
                }
            }
        }
        return isValidationPassed;
    }

    public List<String> getErrors() {
        return errors;
    }

}
