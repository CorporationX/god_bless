package faang.school.godbless.bjs2_5007;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {

    private final Map<String, Consumer<Notification>> messageHandlerConsumerMap = new HashMap<>();


    public void registerHandler(String identifier, Consumer<Notification> notificationConsumer) {
        if (identifier == null) {
            log.info("Identifier can't be null");
        } else if (notificationConsumer == null) {
            log.info("Consumer can't be null");
        }
        messageHandlerConsumerMap.put(identifier, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        if (messageHandlerConsumerMap.get(notification.getType()) == null) {
            log.info("Notification with type {} not found", notification.getType());
        } else {
            messageHandlerConsumerMap.get(notification.getType()).accept(notification);
        }
    }
}
