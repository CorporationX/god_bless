package school.faang.sprint.second.meta;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private static final String DEFAULT_SIGNATURE = " С уважением, Мета";
    private static final Set<String> DENIED_WORDS = Set.of("Кола", "Виски");
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        handlers.putIfAbsent(type, handler);
    }

    public void sendNotification(@NonNull Notification notification) {
        validateNotification(notification);

        Notification modifiedNotification = updateNotification(notification);
        NotificationType notificationType = modifiedNotification.getType();

        handlers.getOrDefault(
                        notificationType,
                        (message) -> log.error("Для {} не найдено сообщение", notificationType))
                .accept(modifiedNotification);
    }

    private void validateNotification(@NonNull Notification notification) {
        String message = notification.getMessage();
        if (notification.getType() == null || message == null) {
            throw new NullPointerException();
        }
        if (message.isBlank()) {
            throw new EmptyMessageException();
        }
        boolean containsDeniedWords = DENIED_WORDS.stream()
                .anyMatch(word -> notification.getMessage().contains(word));

        if (containsDeniedWords) {
            throw new ForbiddenWordException();
        }
    }

    private Notification updateNotification(@NonNull Notification notification) {
        return new Notification(notification.getType(), notification.getMessage() + DEFAULT_SIGNATURE);
    }
}
