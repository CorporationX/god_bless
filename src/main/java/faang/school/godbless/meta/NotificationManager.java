package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();
    private final Map<String, Predicate<Notification>> notificationFilter = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> notificationCorrector = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationHandler) {
        notificationHandlers.put(notificationType, notificationHandler);
    }

    public void sendNotification(Notification notification) {
        notificationHandlers.get(notification.getType()).accept(notification);
    }

    public void registerFilter(String messageToFilter, Predicate<Notification> filter) {
        notificationFilter.put(messageToFilter, filter);
    }

    public boolean checkNotification(String messageToFilter, Notification notification) {
        return notificationFilter.get(messageToFilter).test(notification);
    }

    public void registerCorrector(String messageToCorrect, Function<Notification, Notification> corrector) {
        notificationCorrector.put(messageToCorrect, corrector);
    }

    public Notification correctRejectedNotification(String messageToFilter, Notification notification) {
        return notificationCorrector.get(messageToFilter).apply(notification);
    }
}
