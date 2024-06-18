package faang.school.godbless.metaUniverse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private List<Function<Notification, Notification>> filters = new ArrayList<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void registerFilter(Function<Notification, Notification>  filter) {
        filters.add(filter);
    }

    public void sendNotification(Notification notification) {
        for (Function<Notification, Notification> filter : filters) {
            notification = filter.apply(notification);
        }

        Consumer<Notification> handler = handlers.get(notification.type);
        if(handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для типа оповещения: " + notification.type);
        }
    }
}
