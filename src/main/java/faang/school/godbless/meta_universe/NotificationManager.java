package faang.school.godbless.meta_universe;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@Getter
public class NotificationManager {

    private static final Set<String> NOTIFICATION_TYPES = Set.of("sms", "email", "push");

    private Map<String, Consumer<Notification>> handledNotifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        validateType(type);
        handledNotifications.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        if (handledNotifications.containsKey(type)) {
            Consumer<Notification> handler = handledNotifications.get(type);
            handler.accept(notification);
        }
    }

    private void validateType(String type) {
        if (!NOTIFICATION_TYPES.contains(type.toLowerCase())) {
            throw new IllegalArgumentException("Wrong notification type");
        }
    }
}
