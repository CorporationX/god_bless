package school.faang.meta.notification;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, List<Consumer<Notification>>> handlers = new EnumMap<>(NotificationType.class);
    private final List<Function<Notification, Optional<NotificationType>>> forwarders = new ArrayList<>();
    private final Map<NotificationType, List<Predicate<Notification>>> filtersRule = new HashMap<>();
    private final Map<NotificationType, List<Function<Notification, Notification>>> editNotificationRule
            = new HashMap<>();
    private final Map<NotificationType, AtomicInteger> statistics = new EnumMap<>(NotificationType.class);
    private final AtomicInteger totalBlocked = new AtomicInteger();

    public NotificationManager() {
        for (NotificationType type : NotificationType.values()) {
            statistics.put(type, new AtomicInteger());
        }
    }

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        handlers.computeIfAbsent(type, k -> new ArrayList<>()).add(handler);
    }

    public void addForwardRule(Function<Notification, Optional<NotificationType>> forwardRule) {
        forwarders.add(forwardRule);
    }

    public void addFilterRule(NotificationType type, Predicate<Notification> filter) {
        filtersRule.computeIfAbsent(type, k -> new ArrayList<>()).add(filter);
    }

    public void addEditMessageRule(NotificationType type, Function<Notification, Notification> editRule) {
        editNotificationRule.computeIfAbsent(type, k -> new ArrayList<>()).add(editRule);
    }

    public void sendNotification(@NonNull Notification notification) {
        Notification processedNotification = applyEditRule(applyForwardRule(notification));

        List<Consumer<Notification>> handlersForType = handlers.get(processedNotification.getType());

        if (handlersForType == null || handlersForType.isEmpty()) {
            handleNoHandlers(processedNotification);
            return;
        }

        if (!applyFilterRule(processedNotification)) {
            handleBlockedNotification(processedNotification, handlersForType.size());
            return;
        }

        handlersForType.forEach(handler -> {
            handler.accept(processedNotification);
            incrementStatistics(processedNotification.getType());
        });
    }

    private void handleNoHandlers(Notification notification) {
        totalBlocked.incrementAndGet();
        log.warn("Нет обработчиков для типа: {}", notification.getType());
    }

    private void handleBlockedNotification(Notification notification, int handlersCount) {
        totalBlocked.addAndGet(handlersCount);
        log.warn("Уведомление заблокировано фильтрами: {}", notification);
    }

    private void incrementStatistics(NotificationType type) {
        statistics.computeIfAbsent(type, k -> new AtomicInteger()).incrementAndGet();
    }

    private boolean applyFilterRule(Notification notification) {
        List<Predicate<Notification>> filters = filtersRule.get(notification.getType());
        if (filters == null || filters.isEmpty()) {
            return true;
        }
        return filters.stream().allMatch(filter -> filter.test(notification));
    }

    private Notification applyForwardRule(Notification original) {
        Notification current = original;
        for (Function<Notification, Optional<NotificationType>> forwarder : forwarders) {
            Optional<NotificationType> newType = forwarder.apply(current);
            if (newType.isPresent()) {
                current = new Notification(newType.get(), current.getMessage());
            }
        }
        return current;
    }

    private Notification applyEditRule(Notification original) {
        return editNotificationRule.getOrDefault(original.getType(), Collections.emptyList())
                .stream()
                .reduce(Function.identity(),
                        Function::andThen)
                .apply(original);
    }

    public void printStatistics() {
        log.info("---> Notification Statistics <---");
        log.info("Total processed: {}", getTotalSent());
        log.info("Total successfully sent: {}", getSuccessedSent());
        log.info("Total blocked: {}", totalBlocked.get());

        log.info("By type:");
        statistics.forEach((type, count) ->
                log.info(" -{}: {}", type, count.get()));
    }

    private int getTotalSent() {
        return getSuccessedSent() + totalBlocked.get();
    }

    private int getSuccessedSent() {
        return statistics.values().stream().mapToInt(AtomicInteger::get).sum();
    }
}
