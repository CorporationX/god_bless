package faang.school.godbless.BJS2_22006;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@NoArgsConstructor
public class NotificationManager {
    private Map<String, Consumer<Notification>> messageHandlers = new HashMap<>();

    public void registerHandler(String messageType, Consumer<Notification> consumer) {
        messageHandlers.put(messageType, consumer);
    }

    public void sendNotification (Notification notification) {
        if (messageHandlers.containsKey(notification.getType())) {
            Consumer<Notification> consumer = messageHandlers.get(notification.getType());
            consumer.accept(notification);
        }
    }
}
