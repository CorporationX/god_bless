package faang.school.godbless.MetaUnivers;

import lombok.ToString;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@ToString
public class NotificationManager {

    private final Map<String, Consumer<Notification>> consumerHashMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        consumerHashMap.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        if (consumerHashMap.containsKey(notification.getType())) {
            consumerHashMap.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Такого объекта нет в коллекции");
        }
    }
}
