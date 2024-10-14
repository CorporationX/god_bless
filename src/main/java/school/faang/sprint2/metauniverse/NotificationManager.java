package school.faang.sprint2.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> typeNotificationToConsumer = new HashMap<>();
    private final Map<String, NotificationFilter> filters = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        typeNotificationToConsumer.put(type, consumer);
    }

    public void registerFilter(String type, NotificationFilter filter) {
        filters.put(type, filter);
    }

    public void sendNotification(Notification notification) {
        NotificationFilter filter = filters.get(notification.getType());
        if (filter != null && !filter.test(notification)) {
            System.out.println("Уведомление заблокировано фильтром для типа: " + notification.getType());
            return;
        }
        Consumer<Notification> handler = typeNotificationToConsumer.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для типа:" + notification.getType());
        }
    }

}
