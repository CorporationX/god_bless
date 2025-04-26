package metaUnivers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    private ArrayList<String> badWords = (ArrayList<String>) List.of("яблоко", "дерево", "дом");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = notifications.get(notifications.getNotificationType());

        Predicate<String> check = word -> notification.getMessage().contains(word);
        Function<Notification, Notification> function = n -> new Notification(notification.getNotificationType(), notification.getMessage() + " Название компании")

        if (notificationConsumer != null) {
            if (!checkWords(check)) {
                notificationConsumer.accept(function.apply(notification);
            } else {
                System.out.println("Обнаружено недопустимое слово");
            }

        } else {
            System.out.println("No handler found for type" + notification.getNotificationType());
        }
    }

    private boolean checkWords(Predicate<String> check) {
        return badWords.stream().anyMatch(check);
    }
}
