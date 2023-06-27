package faang.school.godbless.lambda.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> handlerMap = new HashMap<>();

    public void registerHandler(String communicationChannel, Consumer<Notification> consumer) {
        handlerMap.put(communicationChannel, consumer);
    }

    public void sendNotification(Notification notification) {
        if (!handlerMap.containsKey(notification.getType())) {
            System.out.println("No notification handler for type '" + notification.getType() + "'");
        } else {
            handlerMap.get(notification.getType()).accept(notification);
        }

    }
}
