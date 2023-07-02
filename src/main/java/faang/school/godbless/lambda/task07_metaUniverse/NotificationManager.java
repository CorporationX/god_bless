package faang.school.godbless.lambda.task07_metaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer){
        if (type == null && type.isEmpty()) {
            throw new IllegalArgumentException("Пустой тип оповещения");
        } else {
            map.put(type, notificationConsumer);
        }
    }
    public void sendNotification(Notification notification){
        Consumer<Notification> notificationConsumer = map.get(notification.getType());
        map.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}
