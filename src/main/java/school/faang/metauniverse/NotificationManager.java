package school.faang.metauniverse;

import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    @Setter
    private Function<Notification, Notification> corrector;
    private final List<Predicate<Notification>> filters = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        for (Predicate<Notification> filter : filters) {
            if (filter.test(notification)) {
                System.out.println("Сообщение заблокировано!");
                return;
            }
        }
        notification = corrector.apply(notification);
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Такого типа отправки уведомлений не существует!");
        }
    }

    public void addFilters(Predicate<Notification> filter) {
        if (!filters.contains(filter)) {
            filters.add(filter);
        }
    }
}
