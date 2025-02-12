package school.faang.BJS2_57847;

import lombok.NonNull;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Setter
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();
    private Predicate<Notification> filter;
    private Function<Notification, String> spotter;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(@NonNull Notification notification) {
        if (filter != null && filter.test(notification)) {
            System.out.print("Сообщение заблокировано!");
        } else if (spotter != null) {
            System.out.printf("%s", spotter.apply(notification));
        } else {
            notifications.get(notification.getType()).accept(notification);
        }
    }
}
