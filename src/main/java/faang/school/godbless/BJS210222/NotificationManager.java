package faang.school.godbless.BJS210222;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();
    Map<String, Predicate<Notification>> filters = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> notification) {
        map.put(type, notification);
    }

    public void sendNotification(Notification notification) {
        if (map.containsKey(notification.getType())) {
            map.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Такого типа нотификаций нет в БД");
        }
    }

    public void addFilter(String name, Predicate<Notification> notification) {
        filters.put(name, notification);
    }

    public boolean verifyNotification(String nameFilter, Notification notification) {
        return filters.get(nameFilter).test(notification);
    }

    public void sendNotificationWithFilter(Notification notification) {
        if (filters.values().stream().allMatch(filter -> filter.test(notification))) {
            sendNotification(notification);
        } else {
            System.out.println("Сообщение не прошло фильтрацию");
        }
    }


}
