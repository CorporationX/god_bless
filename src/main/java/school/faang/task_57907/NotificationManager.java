package school.faang.task_57907;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();
    private final Map<NotificationFilterType, Predicate<Notification>> notificationFilters = new HashMap<>();
    private final Map<NotificationCorrectorType, Function<Notification, Notification>> notificationCorrectors =
            new HashMap<>();

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        notificationHandlers.putIfAbsent(type, handler);
    }

    public void sendNotification(@NonNull Notification notification) {
        Consumer<Notification> handler = notificationHandlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        }
    }

    public void registerFilter(@NonNull NotificationFilterType type, @NonNull Predicate<Notification> filter) {
        notificationFilters.putIfAbsent(type, filter);
    }

    public boolean isCorrectNotification(@NonNull Notification notification, @NonNull NotificationFilterType type) {
        Predicate<Notification> filter = notificationFilters.get(type);
        return filter.test(notification);
    }

    public void registerCorrector(@NonNull NotificationCorrectorType type,
                                  @NonNull Function<Notification, Notification> corrector) {
        notificationCorrectors.putIfAbsent(type, corrector);
    }

    public Notification adjustNotification(@NonNull Notification notification,
                                           @NonNull NotificationCorrectorType type) {
        Function<Notification, Notification> corrector = notificationCorrectors.get(type);
        return corrector.apply(notification);
    }
}
