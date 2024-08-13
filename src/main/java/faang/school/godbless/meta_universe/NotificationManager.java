package faang.school.godbless.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    public static Map<String, Consumer<Notification>> notificationTypeMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        notificationTypeMap.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (!notificationTypeMap.containsKey(notification.getType())) {
            System.out.println("В хранилище нет типа нотификаций " + notification.getType());
        } else {
            notificationTypeMap.get(notification.getType()).accept(notification);
        }
    }
}
