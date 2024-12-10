package school.faang.task_46701;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<String, Predicate<Notification>> filters = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> correctors = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        notificationTypeCheck(notificationType);
        if (handler == null) {
            throw new IllegalArgumentException("handler не может быть null");
        }
        handlers.put(notificationType, handler);
    }

    public void registerFilter(String notificationType, Predicate<Notification> filter) {
        notificationTypeCheck(notificationType);
        if (filter == null) {
            throw new IllegalArgumentException("filter не может быть null");
        }
        filters.put(notificationType, filter);
    }

    public void registerCorrector(String notificationType, Function<Notification, Notification> corrector) {
        notificationTypeCheck(notificationType);
        if (corrector == null) {
            throw new IllegalArgumentException("corrector не может быть null");
        }
        correctors.put(notificationType, corrector);
    }

    public void sendNotification(Notification notification) {
        filterNotifications(notification);
        Notification modifiedNotification = correctNotifications(notification);

        Optional.ofNullable(handlers.get(modifiedNotification.getType()))
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Не найден обработчик по типу %s", modifiedNotification.getType())))
                .accept(modifiedNotification);
    }

    private void notificationTypeCheck(String notificationType) {
        if (notificationType == null || notificationType.isEmpty()) {
            throw new IllegalArgumentException("notificationType не может быть пустым");
        }
    }

    private void filterNotifications(Notification notification) {
        Optional.ofNullable(filters.get(notification.getType()))
                .filter(filter -> !filter.test(notification)).ifPresent(filter -> {
                    throw new IllegalArgumentException(
                            String.format("Уведоления отфильтрованы %s", notification.getType()));
                });
    }

    private Notification correctNotifications(Notification notification) {
        return Optional.ofNullable(correctors.get(notification.getType()))
                .map(corrector -> corrector.apply(notification))
                .orElse(notification);

    }
}
