package school.faang.bjs2_70626;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationSettings = new HashMap<>();
    private final List<String> censoredWords = List.of("хуй", "пизда", "говно");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationSettings.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationSettings.get(notification.getNotificationType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            throw new HandlerNotFoundException("Уведомление через %s не реализовано"
                    .formatted(notification.getNotificationType()));
        }
    }

    public void censorChecker(Notification notification) {
        boolean isCensored = censoredWords.stream()
                .anyMatch(word -> notification.getMessage().contains(word));
        if (isCensored) {
            throw new IllegalArgumentException("У нас не матерятся!");
        }
    }
}
