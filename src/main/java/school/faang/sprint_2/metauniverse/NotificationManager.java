package school.faang.sprint_2.metauniverse;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Getter
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationHandler = new HashMap<>();
    private List<Predicate> badWords = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        notificationHandler.get(notification.getType()).accept(notification);
    }

    public void registerBadWord(Predicate predicate) {
        badWords.add(predicate);
    }

    public void checkBadWord(Predicate predicate) {

    }
}
