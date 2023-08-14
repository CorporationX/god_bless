package faang.school.godbless.metaUniverse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<String, Consumer<Notification>> chooseNotification = new HashMap<>();
    private List<Predicate<Notification>> messages = new ArrayList<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        chooseNotification.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = chooseNotification.get(notification.getType());
        consumer.accept(notification);
    }

    public void addMessages(Predicate<Notification> predicate) {
        messages.add(predicate);
    }

    public void checkMessages(Notification notification) {
        messages.stream()
                .filter(filter -> filter.test(notification))
                .forEach(f -> System.out.println("Это сообщение содержит подозрительные слова!"));
    }
}