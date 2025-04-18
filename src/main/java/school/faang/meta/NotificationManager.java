package school.faang.meta;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private Predicate<Notification> notificationValidator;
    private static final List<String> BAD_WORDS = List.of("kill", "die", "noob");
    private Function<Notification, Notification> notificationCorrector;

    public NotificationManager() {
        this.notificationValidator = notification -> {
            String message = notification.getMessage().toLowerCase();
            for (String badWord : BAD_WORDS) {
                if (message.contains(badWord)) {
                    return false;
                }
            }
            return true;
        };
        this.notificationCorrector = notification -> {
            String message = notification.getMessage();
            if (!message.contains("Meta")) {
                return new Notification(notification.getType(),
                        message + " Благодарим вас за пользование нашими сервисами!\n Meta Platforms");
            }
            return notification;
        };
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (!notificationValidator.test(notification)) {
            log.info("Notification blocked due to invalid content: {}", notification.getMessage());
            return;
        }
        Notification correctedNotification = notificationCorrector.apply(notification);
        if (handler != null) {
            handler.accept(correctedNotification);
        } else {
            log.info("No handler found for notification type: {}", notification.getType());
        }
    }
}
