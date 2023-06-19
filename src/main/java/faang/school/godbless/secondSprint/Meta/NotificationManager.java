package faang.school.godbless.secondSprint.Meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notifications = new HashMap<>();
    private List<Predicate<Notification>> filters = new ArrayList<>();

    public void registerHandler(String identifier, Consumer<Notification> consumer) {
        notifications.put(identifier, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = notifications.get(notification.getType());
        consumer.accept(notification);
    }

    public void registerFilter(Predicate<Notification> predicate) {
        filters.add(predicate);
    }

    public void checkNotification(Notification notification) {
        filters.stream().filter(filter -> filter.test(notification))
                .forEach(f -> System.out.println("Это оповещение похоже на спам, оно содержит подозрительную фразу"));
    }
}
