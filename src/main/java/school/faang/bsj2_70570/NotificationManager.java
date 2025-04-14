package school.faang.bsj2_70570;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class NotificationManager {

    private Map<NotificationType, Consumer<Notification>> notifications;
    private Map<NotificationType, Predicate<Notification>> profanityFilter;
    private Map<NotificationType, Function<Notification, Notification>> messageChanger;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification) {
        notifications.get(notification.getType()).accept(notification);
    }

    public void registerProfanityFilter(NotificationType type, Predicate<Notification> filter) {
        profanityFilter.putIfAbsent(type, filter);
    }

    public boolean sendProfanityNotification(Notification notification) {
        return profanityFilter.get(notification.getType()).test(notification);
    }

    public void registerMessageChanger(NotificationType type, Function<Notification, Notification> changer) {
        messageChanger.putIfAbsent(type, changer);
    }

    public void changeNotificationMessage(Notification notification) {
        messageChanger.get(notification.getType()).apply(notification);
    }
}
