package faang.school.godbless.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    public static Map<String, Consumer<Notification>> handlersByTypeMap = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlersByTypeMap.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        if (!handlersByTypeMap.containsKey(notification.getType())) {
            System.out.println("В хранилище нет типа нотификаций " + notification.getType());
        } else {
            handlersByTypeMap.get(notification.getType()).accept(notification);
        }
    }
}
