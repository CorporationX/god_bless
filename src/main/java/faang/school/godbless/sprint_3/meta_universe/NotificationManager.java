package faang.school.godbless.sprint_3.meta_universe;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    @Getter
    Map<String, Consumer<Notification>> notificationsList = new HashMap<>();
    @Getter
    List<Predicate<Notification>> predicatesList = new ArrayList<>();

    public void registerHandler(String notificationId, Consumer<Notification> consumer) {
        notificationsList.put(notificationId, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationsList.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        }
    }

    public void filteredNotifications(Predicate<Notification> notification) {
        predicatesList.add(notification);
    }

    public void filter(Notification notification) {
        predicatesList.stream().filter(notificationPredicate -> notificationPredicate.test(notification))
                .forEach(value -> System.out.println("Ваше сообщение имеет запрещенное слово: " + notification.getType()));
    }
}
