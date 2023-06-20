package faang.school.godbless.meta_universe;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@Getter
public class NotificationManager {

    private static final Set<String> VALID_NOTIFICATION_TYPES = Set.of("sms", "email", "push");
    private static final Set<String> MESSAGES_CENSOR = Set.of("fuck", "shit", "cunt", "bitch");

    private Map<String, Consumer<Notification>> notificationsHandler = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        String validType = type.toLowerCase();
        validateType(validType);
        notificationsHandler.put(validType, consumer);
    }

    public void sendNotification(Notification notification) {
        validateNotification(notification);
        String type = notification.getType();

        if (notificationsHandler.containsKey(type)) {
            Consumer<Notification> handler = notificationsHandler.get(type);
            handler.accept(notification);
        }
    }

    private void validateType(String type) {
        if (!VALID_NOTIFICATION_TYPES.contains(type)) {
            throw new IllegalArgumentException("Wrong notification type");
        }
    }

    private void validateNotification(Notification notification) {
        String message = notification.getMessage();
        validateMessage(message);

        if (notification == null) {
            throw new IllegalArgumentException("Notification can't be Null");
        }

        if (message.isBlank()) {
            throw new IllegalArgumentException("Notification massage can't be empty");
        }
    }

    private void validateMessage(String message) {
        Set<String> messageWords = Set.of(message.split(" "));

        messageWords.forEach((word) -> {
            if (MESSAGES_CENSOR.contains(word.toLowerCase())) {
                throw new IllegalArgumentException("Censored word found in message");
            }
        });
    }
}
