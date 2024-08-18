package metaverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private Map<String, Consumer<Notification>> consumerNotification = new HashMap<>();
    private Map<String, Function<Notification, Notification>> filters = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        if (consumerNotification.containsKey(type)){
            throw new IllegalArgumentException("Оповещение уже добавлено");
        }

        this.consumerNotification.put(type, notificationConsumer);
    }

    public void filterHandler(String type, Function<Notification, Notification> filter){
        if (filters.containsKey(type)){
            throw new IllegalArgumentException("Фильтр уже добавлен");
        }
        filters.put(type, filter);
    }

    public void sendNotification(Notification notification) {
        if (this.filters.containsKey(notification.getType())){
            notification = this.filters.get(notification.getType()).apply(notification);
        }

        if (!consumerNotification.containsKey(notification.getType())){
            throw new IllegalArgumentException("Оповещение не найдено");
        }

        consumerNotification.get(notification.getType()).accept(notification);
    }
}
