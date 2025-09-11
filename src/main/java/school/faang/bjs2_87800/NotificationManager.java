package school.faang.bjs2_87800;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> map = new HashMap<>();
    private final Map<NotificationType, Predicate<Notification>> filters = new HashMap<>();
    private final Map<NotificationType, Function<Notification, Notification>> processors = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        map.put(type, handler);
    }

    public void registerFilter(NotificationType type, Predicate<Notification> filter) {
        filters.put(type, filter);
    }

    public void registerProcessor(NotificationType type, Function<Notification, Notification> processor) {
        processors.put(type, processor);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Оповещение не может быть null.");
        }
        if (!map.containsKey(notification.getType())) {
            throw new IllegalArgumentException("Для данного типа уведомления не зарегистрирован обработчик.");
        }

        if (processors.containsKey(notification.getType())) {
            Function<Notification, Notification> function = processors.get(notification.getType());
            notification = function.apply(notification);
        }

        if (filters.containsKey(notification.getType())) {
            Predicate<Notification> predicate = filters.get(notification.getType());
            if (!predicate.test(notification)) {
                System.out.println("Сообщение заблокировано");
                return;
            }
        }

        Consumer<Notification> consumer = map.get(notification.getType());
        consumer.accept(notification);
    }
}
