package school.faang.bjs2_70626;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handler = new HashMap<>();
    private final List<String> censoredWords = List.of("хуй", "пизда", "говно");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        this.handler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        censorChecker(notification1 -> censoredWords.stream().anyMatch(word ->
                notification1.getMessage().contains(word)), notification);
        Consumer<Notification> handle = this.handler.get(notification.getNotificationType());
        if (handle != null) {
            handle.accept(notification);
        } else {
            throw new HandlerNotFoundException("Уведомление через %s не реализовано"
                    .formatted(notification.getNotificationType()));
        }
    }

    private void censorChecker(Predicate<Notification> checker, Notification notification) {
        if (checker.test(notification)) {
            throw new IllegalArgumentException("У нас не матерятся!");
        }
    }
}
