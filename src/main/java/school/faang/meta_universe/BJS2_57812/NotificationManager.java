package school.faang.meta_universe.BJS2_57812;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationManager.class);

    private final Map<NotificationType, Consumer<Notification>> handlerDatabase = new HashMap<>();

    private List<String> forbiddenWords;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        validateObjectNull(type == null, "type ");

        validateObjectNull(handler == null, "handler ");

        if (handlerDatabase.containsKey(type)) {
            LOGGER.error("handler for type {} is already registered", type);
            throw new IllegalArgumentException("Type already registered");
        }

        handlerDatabase.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        validateObjectNull(notification == null, "notification ");

        NotificationType type = notification.type();

        validateObjectNull(type == null, "type ");

        handlerDatabase.get(type).accept(notification);
    }

    public boolean filtering(String message) {
        Predicate<String> containsForbidden = str ->
                forbiddenWords != null && !forbiddenWords.isEmpty() &&
                        forbiddenWords.stream().anyMatch(str::contains);

        if (containsForbidden.test(message)) {
            LOGGER.info("{} contains forbidden words and cannot be used", message);
            return false;
        } else {
            return true;
        }
    }

    public Notification addSender(Notification notification, String sender) {
        validateObjectNull(notification == null, "notification ");
        validateObjectNull(sender == null, "sender ");
        validateStringIsBlank(sender);
        validateStringIsBlank(notification.message());

        Function<Notification, String> messageFunction = n ->
                n.message() + "\nSincerely, " + sender;
        String updatedMessage = messageFunction.apply(notification);
        return new Notification(notification.type(), updatedMessage);
    }

    private static void validateObjectNull(boolean type, String x) {
        if (type) {
            LOGGER.error("{}is null", x);
            throw new NullPointerException(x + "is null");
        }
    }

    private static void validateStringIsBlank(String sender) {
        if (sender.isBlank()) {
            LOGGER.error("sender is empty");
            throw new IllegalArgumentException("sender is empty");
        }
    }
}
