package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class NotificationManager {

    private static final Set<String> VALID_TYPES_NOTIFICATION = Set.of("sms", "email", "push");

    private Map<String, Consumer<Notification>> notificationsHandler = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> consumer){
        if (!VALID_TYPES_NOTIFICATION.contains(type)) {
            throw new IllegalArgumentException("Wrong notification type");
        }
        notificationsHandler.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (notification.getMessage().isBlank()) {
            throw new IllegalArgumentException("Massage cannot be empty");
        }

        String type = notification.getType().toLowerCase();
        if (notificationsHandler.containsKey(type)) {
            Consumer<Notification> handler = notificationsHandler.get(type);
            handler.accept(notification);
        }
    }
}
