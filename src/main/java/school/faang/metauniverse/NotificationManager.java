package school.faang.metauniverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationTypeConsumer = new HashMap<>();
    private final Predicate<String> predicate = message -> {
        String[] arrayWordsMessage = message.split(" +");
        List<String> wordsMessage = Arrays.asList(arrayWordsMessage);
        List<String> profanity = new ArrayList<>(List.of("Слово1", "Слово2", "Слово3"));
        return wordsMessage.stream().noneMatch(profanity::contains);
    };
    private final Function<Notification, Notification> corrector = notification -> {
        Date current = new Date();
        String message = String.format("%s  дата: %s", notification.message(), current);
        checkNotification(notification);

        return new Notification(notification.type(), message);
    };

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        checkType(type);
        checkConsumer(handler);
        notificationTypeConsumer.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        checkNotification(notification);
        Notification correctNotification = corrector.apply(notification);
        if (predicate.test(correctNotification.message())) {
            checkUnknownType(correctNotification);

            notificationTypeConsumer.get(correctNotification.type()).accept(correctNotification);
        } else {
            System.out.println("Недопустимая лексика");
        }
    }

    private void checkUnknownType(Notification notification) {
        if (!notificationTypeConsumer.containsKey(notification.type())) {
            registerHandler(notification.type(),
                    newNotification ->
                            System.out.println("Unknown type: " + notification.message()));
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