package school.faang.bjs2_91602;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(NotificationType notificationType, Consumer<Notification> handler) {
        notificationHandlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        if (filters.stream().anyMatch(filters -> filters.test(notification))) {
            System.out.println("Уведомление заблокировано: " + notification.getMessage());
            return;
        }
        notificationHandlers
                .computeIfAbsent(notification.getType(), notificationType -> n ->
                        System.out.println("Обработчик не найден: " + notificationType))
                .accept(notification);
    }

    public void registerFilters() {
        filters.add(notification -> notification.getMessage().toLowerCase().contains("нецензурн"));
        filters.add(notification -> notification.getMessage().length() > 1000);
        filters.add(notification -> notification.getMessage().toLowerCase().contains("мошенич"));
    }
}
