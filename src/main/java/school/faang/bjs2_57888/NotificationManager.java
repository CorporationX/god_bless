package school.faang.bjs2_57888;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();
    private final List<Function<Notification, Notification>> correctors = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {

        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                System.out.println("Оповещение заблокировано: " + notification.getMessage());
                return;
            }
        }

        Notification correctedNotification = notification;
        for (Function<Notification, Notification> corrector : correctors) {
            correctedNotification = corrector.apply(correctedNotification);
        }

        Consumer<Notification> handler = notifications.get(correctedNotification.getType());
        if (handler != null) {
            handler.accept(correctedNotification);
        } else {
            System.out.println("Отсутствует обработчик для типа события: " + correctedNotification.getType());
        }
    }

    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }

    public void addCorrector(Function<Notification, Notification> corrector) {
        correctors.add(corrector);
    }

}
