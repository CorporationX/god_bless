package school.faang.bjs2_87701;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();
    private static final Set<String> STOP_WORDS = Set.of("мат", "береза");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {

        boolean blocked = filterMessage(notification, n ->
                STOP_WORDS.stream().anyMatch(word -> n.getMessage().toLowerCase().contains(word)));

        if (blocked) {
            log.warn("Сообщение содержит стоп-слова и не будет отправлено: {}", notification.getMessage());
            return;
        }

        Optional.ofNullable(notificationHandlers.get(notification.getType()))
            .ifPresentOrElse(
                    handler -> handler.accept(notification),
                    () -> log.warn("Незарегистрированный тип уведомления: {}", notification.getType())
            );
    }

    private boolean filterMessage(Notification notification, Predicate<Notification> filter) {
        return filter.test(notification);
    }
}
