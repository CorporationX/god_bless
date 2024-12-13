package school.faang.sprint1.task_46827;

import jdk.jfr.Percentage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }

    public void sendNotification(Notification notification) {
        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                System.out.println("Уведомление заблокировано фильтром: " + notification);
                return;
            }
        }
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для типа уведомления: " + notification.getType());
        }
    }
}