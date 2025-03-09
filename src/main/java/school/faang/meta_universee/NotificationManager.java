package school.faang.meta_universee;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<Notification.NotificationType, Consumer<Notification>> idHandlerMap = new HashMap<>();

    public void registerHandler(Notification.NotificationType type, Consumer<Notification> handler) {
        this.idHandlerMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        //вызывает обработчик
        idHandlerMap.get(notification.getType()).accept(notification);
    }

    public void filterNotification(Notification notification) {
        System.out.println(filter(notification, this::filterMessage));
    }

    public String filter(Notification notification, Predicate<Notification> filter) {
        if (filter.test(notification)) {
            return "valid";
        }
        return "not valid";
    }

    public boolean filterMessage(Notification notification) {
        return !notification.getMessage().contains("fuck");
    }

    public Notification correctNotification(Notification notificationSource) {
        Function<Notification, Notification> correctMessage = notification -> {
            String message = notification.getMessage();
            if (!message.isBlank()) {
                if (message.contains("fuck")) {
                    String newMessage = "That's amazing! Our company is fucking Camomile";
                    return new Notification(notification.getType(), newMessage);
                }
            }
            return new Notification(notification.getType(), Objects.toString(notification.getMessage(), "")
                    + " Our company is Camomile");
        };
        return correctMessage.apply(notificationSource);
    }
}
