package faang.school.godbless.sprint3.Meta;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Data
public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationConsumerMap = new HashMap<>();
    private List<Predicate<Notification>> filters = new ArrayList<>();

    public void registerHandler(String notificationId, Consumer<Notification> consumer) {
        notificationConsumerMap.put(notificationId, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = notificationConsumerMap.get(notification.getType());
        consumer.accept(notification);
    }

    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }

    public void filter(Notification notification, int filterNum) {
        if (filterNum >= filters.size())
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        if (filters.get(filterNum).test(notification))
            System.out.println("Censured!!!");
        else
            System.out.println("Message is ok");
    }

}
