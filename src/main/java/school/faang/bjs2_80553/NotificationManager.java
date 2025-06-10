package school.faang.bjs2_80553;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> processorMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        processorMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> processor = processorMap.get(notification.getType());
        if (processor != null) {
            processor.accept(notification);
        } else {
            log.info("{} could not be processed", notification.getType());
        }
    }

    public void sendFilteredNotification(Notification notification, Predicate<Notification> filter) {
        if (filter.test(notification)) {
            sendNotification(notification);
        } else {
            log.info("Notification blocked due to profanity");
        }
    }
}
