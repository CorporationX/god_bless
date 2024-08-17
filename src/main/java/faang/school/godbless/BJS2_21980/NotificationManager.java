package faang.school.godbless.BJS2_21980;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> notificationsByDoneStatus = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void registerFilter(String type, Function<Notification, Notification> filter) {
        notificationsByDoneStatus.put(type, filter);
    }

    public void sendNotification(Notification notification) {
        Function<Notification, Notification> filter = notificationsByDoneStatus.get(notification.getType());
        if (filter != null) {
            notification = filter.apply(notification);
        }

        Consumer<Notification> handler = notifications.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.printf("Обработчик с типом %s не найден\n", notification.getType());
        }
    }
}
