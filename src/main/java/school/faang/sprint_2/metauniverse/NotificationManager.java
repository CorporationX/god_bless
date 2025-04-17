package school.faang.sprint_2.metauniverse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandler = new HashMap<>();
    private final List<Predicate<Notification>> badWords = new ArrayList<>();
    private Function<Notification, Notification> notificationCorrector;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Objects.requireNonNull(notification);
        if (checkBadWord(notification)) {
            notification = editNotification(notification);
        }

        Notification finalNotification = notification;

        Optional.ofNullable(notificationHandler.get(finalNotification.getType()))
                .ifPresent(handler -> handler.accept(finalNotification));
    }

    public void registerBadWord(Predicate<Notification> predicate) {
        badWords.add(predicate);
    }

    public boolean checkBadWord(Notification notification) {
        return badWords.stream()
                .anyMatch(predicate -> predicate.test(notification));
    }

    public void registerCorrection(Function<Notification, Notification> notificationCorrector) {
        this.notificationCorrector = notificationCorrector;
    }

    public Notification editNotification(Notification notification) {
        return notificationCorrector.apply(notification);
    }
}
