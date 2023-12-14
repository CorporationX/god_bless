package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> sendHandlers;
    Map<String, BiFunction<Notification, String, Notification>> contentFiltersHandlers;

    public NotificationManager() {
        this.sendHandlers = new HashMap<>();
        this.contentFiltersHandlers = new HashMap<>();
    }

    void registerSendHandler(String type, Consumer<Notification> sendHandler) {
        sendHandlers.put(type, sendHandler);
    }

    void registerContentFilterHandler(String badWord, BiFunction<Notification, String, Notification> ContentFilterHandler) {
        contentFiltersHandlers.put(badWord, ContentFilterHandler);
    }

    void sendNotification(Notification notification) {
        sendHandlers.get(notification.getType()).accept(notification);
    }

    void check(Notification notification) {
        for (Map.Entry<String, BiFunction<Notification, String, Notification>> badWords : contentFiltersHandlers.entrySet()) {
            String badWord = badWords.getKey();
            if (notification.getMessage().contains(badWord)) {
                contentFiltersHandlers.get(badWord).apply(notification, badWord);
            }
        }
    }
}
