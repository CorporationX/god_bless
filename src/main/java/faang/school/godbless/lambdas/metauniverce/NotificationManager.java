package faang.school.godbless.lambdas.metauniverce;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlerByType = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        handlerByType.put(type, consumer);
    }
    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlerByType.get(notification.getType());
        handler.accept(notification);
    }
}
