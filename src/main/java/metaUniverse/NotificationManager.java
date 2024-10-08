package metaUniverse;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@Data
public class NotificationManager {
    private static final Map<String, Consumer<Notification>> TYPE_TO_NOTIFICATION_TO_CONSUMER = new HashMap<>();
    private static final Map<String, Function<Notification, Notification>> TYPE_FILTER_TO_FILTER_MAP = new HashMap<>();
    @Getter
    private static final List<String> BAN_WORDS = List.of("golang", "c#");

    void registerHandler(String type, Consumer<Notification> consumer) {
        TYPE_TO_NOTIFICATION_TO_CONSUMER.put(type, consumer);
    }

    void registerFilter(String type, Function<Notification, Notification> filter) {
        TYPE_FILTER_TO_FILTER_MAP.put(type, filter);
    }

    void sendNotification(Notification notification, String typeFilter) {
        Function<Notification, Notification> filter = TYPE_FILTER_TO_FILTER_MAP.get(typeFilter);
        Consumer<Notification> handler = TYPE_TO_NOTIFICATION_TO_CONSUMER.get(notification.getType());
        handler.accept(filter.apply(notification));
    }
}
