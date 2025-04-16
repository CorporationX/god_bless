package school.faang.sprint_2.metauniverse;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationHandler = new HashMap<>();
    private List<Predicate<Notification>> badWords = new ArrayList<>();
    private Function<Notification, Notification> notificationCorrector;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (checkBadWord(notification)) {
            notification = editNotification(notification);
        }

        notificationHandler.get(notification.getType()).accept(notification);
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
