package school.faang.sprint2.tast_bjs246757;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@ToString
public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        map.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = map.get(notification.getType());

        if (notificationConsumer != null) {
            notificationConsumer.accept(notification);
        } else {
            System.out.println("Такого события не существует: " + notification.getType());
        }
    }
}
