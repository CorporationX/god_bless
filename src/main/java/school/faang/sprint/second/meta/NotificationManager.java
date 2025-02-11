package school.faang.sprint.second.meta;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private static final String DEFAULT_MESSAGE = " С уважением, Мета";
    private static final Set<String> DENIED_WORDS = Set.of("Кола", "Виски");
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        handlers.putIfAbsent(type, handler);
    }

    public void sendNotification(@NonNull Notification notification) {
        if (notification.getMessage().isBlank()) {
            throw new IllegalArgumentException("Нельзя передавать пустое сообщение");
        }
        if (!isValidMessage(notification)) {
            throw new IllegalArgumentException("Ваше сообщение содержит запрещенные слова");
        }

        Notification modifiedNotification = updateNotification(notification);
        NotificationType notificationType = modifiedNotification.getType();

        handlers.getOrDefault(
                        notificationType,
                        (message) -> log.error("Для {} не найдено сообщение", notificationType))
                .accept(modifiedNotification);
    }

    private boolean isValidMessage(@NonNull Notification notification) {
        return DENIED_WORDS.stream().noneMatch(word -> notification.getMessage().contains(word));
    }

    private Notification updateNotification(@NonNull Notification notification) {
        return new Notification(notification.getType(), notification.getMessage() + DEFAULT_MESSAGE);
    }
}
