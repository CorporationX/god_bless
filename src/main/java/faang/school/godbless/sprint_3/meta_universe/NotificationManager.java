package faang.school.godbless.sprint_3.meta_universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();
    List<Predicate<Notification>> consumerList = new ArrayList<>();

    public void registerHandler(String notificationId, Consumer<Notification> consumer) {
        map.put(notificationId, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = map.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        }
    }

    public void filteredNotification(Predicate<Notification> notification) {
        consumerList.add(notification);
    }

    public void filter(Notification notification) {
        consumerList.stream().filter(notificationPredicate -> notificationPredicate.test(notification))
                .forEach(value -> System.out.println("Ваше сообщение имеет запрещенное слово: " + notification.getType()));
    }
}
