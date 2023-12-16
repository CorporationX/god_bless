package faang.school.godbless.BJS2_748;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> registerHandler = new HashMap<>();
    private Map<String, BiFunction<String, Notification, Notification>> censoredHandler = new HashMap<>();
    private List<String> censoredWords = new ArrayList<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationAction) {
        this.registerHandler.put(notificationType, notificationAction);
    }

    public void censoredWords(String notificationType, List<String> censoredWords) {
        this.censoredWords.addAll(censoredWords);
    }

    public void censoredHandler(String notificationType, BiFunction<String, Notification, Notification> censorAction) {
        this.censoredHandler.put(notificationType, censorAction);
    }

    public void sendNotification(Notification notification) {
        String notificationType = notification.getType();

        if (censoredHandler.containsKey(notificationType)) {
            for (String word : censoredWords) {
                if (notification.getMessage().contains(word)) {
                    notification = this.censoredHandler.get(notificationType).apply(word, notification);
                    break;
                }
            }
        }

        this.registerHandler.getOrDefault(notificationType, (notif) -> System.out.println("Action not found for notification type: " + notificationType))
                .accept(notification);
    }
}