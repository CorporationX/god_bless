package school.faang.bjs2_71975;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, List<Consumer<Notification>>> consumerMap = new HashMap<>();
    private final Map<NotificationType, List<Predicate<Notification>>> predicateMap = new HashMap<>();
    private final Map<NotificationType, List<Function<Notification, Notification>>> functionMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        consumerMap.computeIfAbsent(type, notificationType -> new ArrayList<>()).add(handler);
    }

    public void registerPredicate(NotificationType type, Predicate<Notification> predicate) {
        predicateMap.computeIfAbsent(type, notificationType -> new ArrayList<>()).add(predicate);
    }

    public void registerFunction(NotificationType type, Function<Notification, Notification> modifier) {
        functionMap.computeIfAbsent(type, notificationType -> new ArrayList<>()).add(modifier);
    }

    public void sendNotification(Notification notification) {
        List<Predicate<Notification>> predicates = predicateMap.getOrDefault(notification.type(), List.of());
        for (Predicate<Notification> predicate : predicates) {
            if (!predicate.test(notification)) {
                log.info("Уведомление {} с типом {} заблокировано предикатом", notification.message(), notification.type());
                return;
            }
        }

        List<Function<Notification, Notification>> modifiers = functionMap.getOrDefault(notification.type(), List.of());
        modifiers.forEach(modifier -> modifier.apply(notification));

        List<Consumer<Notification>> handlers = consumerMap.get(notification.type());
        if (handlers == null || handlers.isEmpty()) {
            log.warn("Нет зарегестрированных консьюмеров по типу {}", notification.type());
            return;
        }

        for (Consumer<Notification> consumer : handlers) {
            consumer.accept(notification);
        }
    }
}
