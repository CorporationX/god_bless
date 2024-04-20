package faang.school.godbless.BJS2_5478;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private static final Map<String, Consumer<Notification>> NOTIFICATION_HANDLERS = new HashMap<>();

    public void registerHandler(String notification, Consumer<Notification> notificationConsumer) {
        validateDataRegisterHandler(notification, notificationConsumer);
        NOTIFICATION_HANDLERS.putIfAbsent(notification, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        validateNotification(notification);
        if (NOTIFICATION_HANDLERS.containsKey(notification.getType())) {
            NOTIFICATION_HANDLERS.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Not handler notification type: " + notification.getType());
        }
//        NOTIFICATION_HANDLERS.computeIfPresent(notification.getType(), (key, value) -> {
//            value.accept(notification);
//            return value;
//        });
    }

    private void validateDataRegisterHandler(String stringData, Consumer<Notification> handlerData) {
        if (stringData.isBlank() || handlerData == null) {
            throw new IllegalArgumentException("Invalid data register handler");
        }
    }

    private void validateNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Invalid data send notification");
        }
    }
}
