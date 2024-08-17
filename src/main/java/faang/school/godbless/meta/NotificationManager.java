package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handleByType = new HashMap<>();
    private final Map<String, Predicate<Notification>> filterByMessage = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> correctByMessage = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationHandler) {
        handleByType.put(notificationType, notificationHandler);
    }

    public void sendNotification(Notification notification) {
        if (handleByType.containsKey(notification.getType())) {
            handleByType.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Not registered handler for that notification type: " + notification.getType());
        }
    }

    public void registerFilter(String messageToFilter, Predicate<Notification> filter) {
        filterByMessage.put(messageToFilter, filter);
    }

    public Optional<Boolean> checkNotification(String messageToFilter, Notification notification) {
        if (filterByMessage.containsKey(messageToFilter)) {
            return Optional.of(filterByMessage.get(messageToFilter).test(notification));
        } else {
            System.out.println("Not registered filter for that message : " + messageToFilter);
            return Optional.empty();
        }
    }

    public void registerCorrector(String messageToCorrect, Function<Notification, Notification> corrector) {
        correctByMessage.put(messageToCorrect, corrector);
    }

    public Optional<Notification> correctRejectedNotification(String messageToCorrect, Notification notification) {
        if (filterByMessage.containsKey(messageToCorrect)) {
            return Optional.of(correctByMessage.get(messageToCorrect).apply(notification));
        } else {
            System.out.println("Not registered corrector for that message : " + messageToCorrect);
            return Optional.empty();
        }
    }
}
