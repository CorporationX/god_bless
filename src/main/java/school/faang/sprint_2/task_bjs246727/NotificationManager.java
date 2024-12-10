package school.faang.sprint_2.task_bjs246727;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final Logger log = LoggerFactory.getLogger(NotificationManager.class);

    public void registerHandler(NotificationType notificationType, Consumer<Notification> handler) {
        inputValidation("registerHandler", notificationType, handler);
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        inputValidation("sendNotification", notification);
        Optional.ofNullable(handlers.get(notification.type()))
                .ifPresentOrElse(
                        handler -> handler.accept(notification),
                        () -> {
                            throw new NoSuchElementException("No such notification type");
                        });
    }

    private <T> void inputValidation(String methodName, T object1) {
        if (object1 == null) {
            log.warn("Get null input data in method {}", methodName);
            throw new IllegalArgumentException("Input data in method " + methodName + " cannot be null");
        }
    }

    private <T> void inputValidation(String methodName, T object1, T object2) {
        if (object1 == null || object2 == null) {
            log.warn("Get null input data in method {}", methodName);
            throw new IllegalArgumentException("Input data in method " + methodName + " cannot be null");
        }
    }
}