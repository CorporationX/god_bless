package Meta_universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class NotificationManager {
    private static final Logger logger = Logger.getLogger(NotificationManager.class.getName());
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private Function<Notification, Notification> messageCorrector;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null || handler == null) {
            String errorMessage = "Type and handler cannot be null!";
            logger.severe(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        if (handlers.containsKey(type)) {
            String errorMsg = "Handler for " + type + " is already registered!";
            logger.severe(errorMsg);
            throw new IllegalStateException(errorMsg);
        }
        handlers.put(type, handler);
        logger.info("Handler registered for " + type);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Meta_universe.Notification cannot be null!");
        }

        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            logger.warning("No handler registered for " + notification.getType());
        }

        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                logger.info("Meta_universe.Notification blocked: " + notification.getMessage());
                return;
            }
        }

        if (messageCorrector != null) {
            notification = messageCorrector.apply(notification);
            logger.info("Meta_universe.Notification message corrected: " + notification.getMessage());
        }
    }

    public void addFilter(Predicate<Notification> filter) {
        if (filter == null) {
            throw new IllegalArgumentException("Filter cannot be null!");
        }
        if (filters.contains(filter)) {
            throw new IllegalStateException("This filter is already added!");
        }
        filters.add(filter);
        logger.info("Filter added: Meta_universe.Notification message should not contain 'fishing'");
    }

    public void setMessageCorrector(Function<Notification, Notification> corrector) {
        if (corrector == null) {
            throw new IllegalArgumentException("Message corrector cannot be null!");
        }
        this.messageCorrector = corrector;
        logger.info("Message corrector set!");
    }
}
