package metaUniverse;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@Data
public class NotificationManager {
    private final Map<String, Consumer<Notification>> typeNotificationToConsumer = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> typeFilterToFilterMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        typeNotificationToConsumer.put(type, consumer);
    }

    public void registerFilter(String type, Function<Notification, Notification> filter) {
        typeFilterToFilterMap.put(type, filter);
    }

    public void sendNotification(Notification notification, String typeFilter) {
        Function<Notification, Notification> filter = typeFilterToFilterMap.get(typeFilter);
        Consumer<Notification> handler = typeNotificationToConsumer.get(notification.getType());
        handler.accept(filter.apply(notification));
    }
}
