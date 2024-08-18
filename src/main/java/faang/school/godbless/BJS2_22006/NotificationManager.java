package faang.school.godbless.BJS2_22006;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@NoArgsConstructor
public class NotificationManager {
    private Map<String, Consumer<Notification>> messageHandlers = new HashMap<>();
    private List<Predicate<Notification>> filters = new ArrayList<>();

    public void registerHandler(String messageType, Consumer<Notification> consumer) {
        messageHandlers.put(messageType, consumer);
    }

    public void sendNotification(Notification notification) {
        if (messageHandlers.containsKey(notification.getType())) {
            Consumer<Notification> consumer = messageHandlers.get(notification.getType());
            consumer.accept(notification);
        }
    }

    public void addNotificationFilter(Predicate<Notification> predicate) {
        filters.add(predicate);
    }

    public boolean isValidNotification(Notification notification) {
        boolean isValid = true;
        for (Predicate<Notification> filter : filters) {
            isValid &= filter.test(notification);
        }
        return isValid;
    }
}
