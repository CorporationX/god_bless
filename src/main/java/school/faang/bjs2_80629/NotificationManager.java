package school.faang.bjs2_80629;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    
    @Setter
    private Predicate<Notification> filter = n -> true;
    @Setter
    private Function<Notification, Notification> corrector = Function.identity();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
        log.info("{} handler registered", type);
    }

    public void sendNotification(Notification notification) {
        if (!filter.test(notification)) {
            log.warn("Notification blocked by filter: {}", notification);
            return;
        }

        Notification correctedNotification = corrector.apply(notification);

        Consumer<Notification> handler = handlers.get(correctedNotification.type());
        if (handler != null) {
            handler.accept(correctedNotification);
        } else {
            log.error("No handler registered for type {}", correctedNotification.type());
        }
    }
}
