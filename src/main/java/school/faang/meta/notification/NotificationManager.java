package school.faang.meta.notification;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, List<Consumer<Notification>>> handlers = new EnumMap<>(NotificationType.class);
    private final NotificationForwarder forwarder = new NotificationForwarder();
    private final NotificationFilter filter = new NotificationFilter();
    private final NotificationEditor editor = new NotificationEditor();
    private final NotificationStatistics statistics = new NotificationStatistics();

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        this.handlers.computeIfAbsent(type, k -> new ArrayList<>()).add(handler);
    }

    public void addForwardRule(Function<Notification, Optional<NotificationType>> forwardRule) {
        this.forwarder.addForwardRule(forwardRule);
    }

    public void addFilterRule(NotificationType type, Predicate<Notification> filterRule) {
        this.filter.addFilter(type, filterRule);
    }

    public void addEditMessageRule(NotificationType type, Function<Notification, Notification> editRule) {
        this.editor.addEditRule(type, editRule);
    }

    public void sendNotification(@NonNull Notification notification) {
        Notification processedNotification = this.editor.applyEditRules(this.forwarder.applyForwardRules(notification));
        List<Consumer<Notification>> handlersForType = this.handlers.get(processedNotification.getType());

        if (handlersForType == null || handlersForType.isEmpty()) {
            handleNoHandlers(processedNotification);
            return;
        }

        if (!this.filter.applyFilters(processedNotification)) {
            handleBlockedNotification(processedNotification, handlersForType.size());
            return;
        }

        handlersForType.forEach(handler -> {
            handler.accept(processedNotification);
            this.statistics.increment(processedNotification.getType());
        });
    }

    private void handleNoHandlers(Notification notification) {
        this.statistics.addBlocked(1);
        log.warn("Нет обработчиков для типа: {}", notification.getType());
    }

    private void handleBlockedNotification(Notification notification, int handlersCount) {
        this.statistics.addBlocked(handlersCount);
        log.warn("Уведомление заблокировано фильтрами: {}", notification);
    }

    public void printStatistics() {
        this.statistics.printStatistics();
    }
}
