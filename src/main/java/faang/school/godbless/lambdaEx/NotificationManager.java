package faang.school.godbless.lambdaEx;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class NotificationManager {

    private Map<String, Consumer<Notification>> notifications = new HashMap<>();


    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        notifications.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        notifications.getOrDefault(notification.getType(), x -> System.out.println("wrong type")).accept(notification);
    }
}
