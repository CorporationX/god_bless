package school.faang.bjs270591;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> consumerMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        consumerMap.put(type, handler);
        log.info("Registered handler for " + type);
    }

    public void sendNotification(Notification notification) {
        for (Map.Entry<NotificationType, Consumer<Notification>> entry : consumerMap.entrySet()) {
            log.info("Sending notification " + entry.getKey());
            entry.getValue().accept(notification);

        }
    }
}
