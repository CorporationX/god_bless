package faang.school.godbless.lambda.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        var handler = handlers.getOrDefault(notification.getType(),
                (s) -> System.out.printf("Not found handler for '%s'%n", s.getType())
        );
        handler.accept(notification);
    }

}
