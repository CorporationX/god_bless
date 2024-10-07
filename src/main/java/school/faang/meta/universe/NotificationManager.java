package school.faang.meta.universe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<Filter, Consumer<Notification>> filterToHandler = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Индентификатор не может быть пустым или null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("handler не может быть null");
        }

        handlers.put(type, handler);
    }

    public void registerFilter(Filter filter, Consumer<Notification> handler) {
        if (filter == null) {
            throw new IllegalArgumentException("filter не может быть null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("handler не может быть null");
        }

        filterToHandler.put(filter, handler);
    }

    public void sendNotification(Notification notification, List<Filter> filters) {
        if (notification == null) {
            throw new IllegalArgumentException("notification не может быть null");
        }
        if (filters == null) {
            throw new IllegalArgumentException("filters не может быть null");
        }
        Consumer<Notification> notificationHandler = handlers.get(notification.getType());
        if (notificationHandler == null) {
            throw new IllegalArgumentException("Обработчик с таким идентификатором не был найден");
        }

        applyFilters(notification, filters);
        notificationHandler.accept(notification);
    }

    private void applyFilters(Notification notification, List<Filter> filters) {
        for (Filter filter : filters) {
            Consumer<Notification> filterHandler = filterToHandler.get(filter);
            if (filterHandler == null) {
                throw new IllegalArgumentException("Фильтр" + filter + "не зарегистрирован");
            }
            filterHandler.accept(notification);
        }
    }
}
