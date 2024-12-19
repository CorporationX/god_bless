package school.faang.sprint2.task46797metauniverse2;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    static Map<String, Consumer<Notification>> handlerTypeNotification = new HashMap<>();
    static Map<String, Predicate<Notification>> handlerTypeFilter = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        if (type != null && !type.isEmpty() && handler != null) {
            handlerTypeNotification.put(type, handler);
        } else {
            throw new IllegalArgumentException("Некорректные значени");
        }
    }

    public void sendNotification(Notification notification, List<Filter> filters) {
        String type = notification.getType();

        if (handlerTypeNotification.containsKey(type)) {
            if (filters == null || filters.isEmpty()) {
                Consumer<Notification> handlerNotification = handlerTypeNotification.get(type);
                handlerNotification.accept(notification);
                return;
            }
            for (Filter filter : filters) {
                Predicate<Notification> filterPredicate = handlerTypeFilter.get(filter.getTypeFilter());

                if (filterPredicate != null) {
                    boolean isFiltered = filterPredicate.test(notification);
                    if (isFiltered) {
                        filter.addFilteredNotifications(notification);
                    } else {
                        log.info("Фильтр {} не выявил ничего подозрительного", filter.getTypeFilter());
                    }
                }
            }
            Consumer<Notification> handlerNotification = handlerTypeNotification.get(type);
            handlerNotification.accept(notification);
        } else {
            log.warn("Нет обработчика для типа уведомления: {}", type);
        }
    }

    public void sendNotification(Notification notification) {
        sendNotification(notification, null);
    }

    public void addFilter(String typeFilter, Predicate<Notification> filter) {
        if (typeFilter != null && filter != null && !typeFilter.isEmpty()) {
            handlerTypeFilter.put(typeFilter, filter);
            log.info("Фильтр добавлен для типа: {}", typeFilter);
        } else {
            throw new IllegalArgumentException("Плохие входные данные");
        }
    }
}
