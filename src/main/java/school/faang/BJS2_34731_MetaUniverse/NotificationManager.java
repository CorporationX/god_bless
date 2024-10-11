package school.faang.BJS2_34731_MetaUniverse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private HashMap<String, Consumer<Notification>> handlersByNotificationsTypes;
    private HashMap<String, Predicate<Notification>> filtersByNames;

    public NotificationManager() {
        handlersByNotificationsTypes = new HashMap<>();
        filtersByNames = new HashMap<>();
    }

    public void registerHandler(String notificationType, Consumer<Notification> notificationHandler) {
        validateString(notificationType, "Invalid notification type!");
        validateConsumer(notificationHandler, "Notification handler can't be null!");
        handlersByNotificationsTypes.put(notificationType.toLowerCase(), notificationHandler);
    }

    public void sendNotification(Notification notification) {
        validateNotification(notification);

        boolean isValidNotification = true;
        for (var entry: filtersByNames.entrySet()) {
            if (entry.getValue().test(notification)) {
                isValidNotification = false;
            }
        }

        if (isValidNotification) {
            Optional.ofNullable(handlersByNotificationsTypes.get(notification.getType()))
                    .ifPresentOrElse(
                            handler -> handler.accept(notification),
                            () -> System.out.println("Unknown type of notification.\nNotification has not been sent.\n")
                    );
        } else {
            System.out.println("Notification has not been sent due to triggered filters for its message.\n");
        }
    }

    public void registerFilter(String filterName, Predicate<Notification> filterLogic) {
        validateString(filterName, "Invalid filter name!");
        validatePredicate(filterLogic, "Invalid filter!");
        filtersByNames.put(filterName, filterLogic);
    }

    private void validateConsumer(Consumer<?> consumer, String message) {
        if (consumer == null) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validatePredicate(Predicate<?> predicate, String message) {
        if (predicate == null) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateString(String info, String message) {
        if (info == null || info.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateNotification(Notification notification) {
        if (notification != null) {
            validateString(notification.getType(), "Invalid notification type!");
            validateString(notification.getMessage(), "Invalid notification message text!");
        } else {
            throw new IllegalArgumentException("Notification can't be null!");
        }
    }
}
