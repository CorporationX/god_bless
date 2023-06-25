package Meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    Map<String, Consumer<Notification>> notifications = new HashMap<>();
    List<Predicate<Notification>> filter = new ArrayList<>();

    public void registerHandler(String indetificator, Consumer<Notification> consumer){
        notifications.put(indetificator, consumer);
    }

    public void sendNotification(Notification notification){
        Consumer<Notification> consumer = notifications.get(notification.getType());
        consumer.accept(notification);
    }

    public void addToFilter(Predicate<Notification> notificationPredicate){
        filter.add(notificationPredicate);
    }

    public void validateMessage(Notification notification){
        filter.stream()
                .filter(s -> s.test(notification))
                .forEach(s -> System.out.println("I found some spam"));
    }

}
