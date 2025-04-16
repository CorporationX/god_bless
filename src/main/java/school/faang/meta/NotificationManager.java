package school.faang.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private final List<Function<Notification, Notification>> correctors = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }

    public void addCorrector(Function<Notification, Notification> corrector) {
        correctors.add(corrector);
    }

    public void sendNotification(Notification notification) {
        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                System.out.println("notification blocked by filter! " + notification.getMessage());
                return;
            }
        }

        for (Function<Notification, Notification> corrector : correctors) {
            notification = corrector.apply(notification);
        }

        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println(notification.getType() + " not found");
        }
    }

}
