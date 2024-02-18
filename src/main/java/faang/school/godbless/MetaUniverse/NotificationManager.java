package faang.school.godbless.MetaUniverse;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final static Map<String, Consumer<Notification>> listOfNotificationTypes = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        listOfNotificationTypes.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> output = listOfNotificationTypes.get(notification.getType());
        output.accept(notification);
    }
}