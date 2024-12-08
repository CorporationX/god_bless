package school.faang.task_46597;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationPerId = new HashMap<>();
    private final List<Function<Notification, Notification>> filters = new ArrayList<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        if (StringUtils.isBlank(type)) {
            throw new IllegalArgumentException("Type is incorrect!");
        }
        notificationPerId.put(type, consumer);
    }

    public void addFilter(Function<Notification, Notification> filter) {
        filters.add(filter);
    }

    public void sendNotification(Notification notification) {
        for (Function<Notification, Notification> filter : filters) {
            notification = filter.apply(notification);
        }

        Consumer<Notification> handler = notificationPerId.get(notification.type());
        if (handler != null) {
            handler.accept(notification);
        }
    }
}
