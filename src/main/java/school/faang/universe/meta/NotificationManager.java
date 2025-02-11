package school.faang.universe.meta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private static final Logger logger = LoggerFactory.getLogger(NotificationManager.class);
    private static final String SUBSCRIPTION = " With care for you, our Meta";
    private final Map<NotificationType, Consumer<Notification>> notificationManagerMap = new HashMap<>();
    private final Set<String> forbiddenWords = Set.of("badword", "forbidden", "curse");
    private final Predicate<Notification> predicate = notification -> forbiddenWords.stream()
            .anyMatch(word -> notification.getMessage().toLowerCase().contains(word.toLowerCase()));
    private final Function<Notification, Notification> notificationChanger = notification ->
            new Notification(notification.getType(), notification.getMessage() + SUBSCRIPTION);

    public boolean registerHandler(NotificationType type, Consumer<Notification> handler) {
        checkValidArgument(type, "notification type");
        checkValidArgument(handler, "handler");
        if (notificationManagerMap.putIfAbsent(type, handler) == null) {
            logger.info("An {} handler has been registered", type);
            return true;
        }
        logger.info("The handler for the {} already exists", type);
        return false;
    }

    public boolean sendNotification(Notification notification) {
        checkValidArgument(notification, "notification");
        Consumer<Notification> notificationConsumer = notificationManagerMap.get(notification.getType());
        if (notificationConsumer != null && !predicate.test(notification)) {
            notificationChanger.apply(notification);
            notificationConsumer.accept(notification);
            logger.info("The notification was sent successfully: type - {}, message - {}",
                    notification.getType(), notification.getMessage());
            return true;
        }
        logger.error("The handler for this notification type '{}' was not found.", notification.getType());
        return false;
    }

    private <T> void checkValidArgument(T argument, String argumentName) {
        if (argument == null) {
            throw new IllegalArgumentException("The " + argumentName + " type cannot be null.");
        }
        if (argument.getClass() == String.class && ((String) argument).isBlank()) {
            throw new IllegalArgumentException("The " + argumentName + " type cannot be blank.");
        }
    }
}
