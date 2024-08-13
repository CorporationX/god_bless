package faang.school.godbless.metaworld;

import lombok.Setter;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;


public class NotificationManager {
    private final String inappropriateWords = "[pP][oO][pP][aA]|[jJ][oO][pP][aA]";//нецензурная лексика
    private Map<NotificationType, Consumer<Notification>> senders;
    @Setter
    private Function<Notification, Notification> filter;

    public NotificationManager() {
        senders = new EnumMap<>(NotificationType.class);
        filter = registerFilter(); //фильтр по умолчанию
    }

    public void registerHandler(NotificationType type, Consumer<Notification> consumer) {
        senders.put(type, consumer);
    }

    public Function<Notification, Notification> registerFilter() {
        return (notification -> {
            notification.setMessage(notification.getMessage().replaceAll(inappropriateWords, "***"));
            return notification;
        });
    }

    public void sendNotification(Notification notification) {
        try {
            if (filter != null) {
                senders.get(notification.getType()).accept(
                        filter.apply(notification)
                );
            } else {
                senders.get(notification.getType()).accept(notification);
            }
        } catch (NullPointerException e) {
            System.err.println("have not " + notification.getType().toString() + " handler");
            throw new RuntimeException();
        }

    }
}
