package faang.school.godbless.sprint_2.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private Map<String, Consumer<Notification>> handlers;
    private BadWordsManager badWordsManager;

    public NotificationManager(BadWordsManager badWordsManager) {
        this.handlers = new HashMap<>();
        this.badWordsManager = badWordsManager;
    }

    void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    void sendNotification(Notification notification) {
        String validateMessage = badWordsManager.validateMessage(notification.getMessage());
        notification.setMessage(validateMessage);
        handlers.get(notification.getType()).accept(notification);
    }
}