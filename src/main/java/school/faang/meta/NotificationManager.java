package school.faang.meta;

import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Проект: god_bless
 * Класс NotificationManager
 * Автор: Vital
 * Дата: 17.09.2025
 */

@Setter(onParam_ = @NonNull)
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlders = new HashMap<>();

    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private final List<Function<Notification, Notification>> correctors = new ArrayList<>();

    @NonNull
    private Consumer<Notification> defaultHandler =
            notification -> System.out.printf("%nОбработчик для %s не найден! Сообщение: %s",
                    notification.getType(), notification.getMessage());

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handlers) {
        notificationHandlders.put(type, handlers);
    }

    public void addFilter(@NonNull Predicate<Notification> filter) {
        filters.add(filter);
    }

    public void addCorrector(@NonNull Function<Notification, Notification> corrector) {
        correctors.add(corrector);
    }

    public void sendNotification(@NonNull Notification notification) {
        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                System.out.printf("\nОповещение заблокировано: %s", notification.getMessage());
                return;
            }
        }

        for (Function<Notification, Notification> corrector : correctors) {
            notification = corrector.apply(notification);
            if (notification == null) {
                System.out.println("Корректор вернул null. Оповещение отброшено.");
                return;
            }
        }

        Consumer<Notification> handler = notificationHandlders.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            defaultHandler.accept(notification);
        }
    }
}