package school.faang.metauniverse;

import java.util.HashMap;
import java.util.Map;


public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationTypeConsumer = new HashMap<>();
    private final Predicate<String> predicate = message -> {
        //логика проверки сообщения на нецензурную лексику
        return true;
    };
    private final Function<Notification, Notification> corrector = notification -> {
        //логика корректировки содержания оповещений перед отправкой
        checkNotification(notification);
        return notification;
    };

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        checkType(type);
        checkConsumer(handler);
        notificationTypeConsumer.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Notification correctNotification = corrector.apply(notification);
        if (predicate.test(correctNotification.getMessage())) {

            if (!notificationTypeConsumer.containsKey(correctNotification.getType())) {
                registerHandler(correctNotification.getType(),
                        newNotification ->
                                System.out.println("Unknown type: " + correctNotification.getMessage()));
            }
            notificationTypeConsumer.get(correctNotification.getType()).accept(correctNotification);
        } else {
            System.out.println("Недопустимая лексика");
        }
    }

    public void checkNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Оповещение не может быть null");
        }
    }

    public void checkType(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException("Тип оповещения не может быть null");
        }
    }

    public void checkConsumer(Consumer<Notification> handler) {
        if (handler == null) {
            throw new IllegalArgumentException("Обработчик оповещений не может быть null");
        }
    }
}