package school.faang.lambda.meta_universe;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlerContainer = new HashMap<>();
    private Predicate<Notification> messageChecker;
    private Function<Notification, Notification> signFromSender;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlerContainer.put(type, handler);
    }

    public void registerChecker(Predicate<Notification> handler) {
        messageChecker = handler;
    }

    public void registerSignWriter(Function<Notification, Notification> addition) {
        signFromSender = addition;
    }

    public void sendNotification(Notification notification) {
        handlerContainer.get(notification.getType()).accept(notification);
    }

    public void checkNotificationMessage(Notification notification) {
        if (messageChecker != null) {
            boolean result = messageChecker.test(notification);
            log.info("Your message contains offensive language - {}", result);
        } else {
            log.info("You dont have registered message checker");
        }
    }

    public Notification fillSender(Notification notification) {
        if (signFromSender != null) {
            return signFromSender.apply(notification);
        } else {
            log.info("You dont have registered message sender");
            return notification;
        }
    }


}
