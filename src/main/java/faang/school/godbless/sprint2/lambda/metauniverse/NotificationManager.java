package faang.school.godbless.sprint2.lambda.metauniverse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private Map<String, List<Consumer<Notification>>> typeToHandlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        typeToHandlers.computeIfAbsent(type, k -> new ArrayList<>()).add(handler);
    }

    public void sendNotification(Notification notification) {
        List<Consumer<Notification>> handlers = typeToHandlers.get(notification.getType());
        if (handlers != null && !handlers.isEmpty()) {
            handlers.forEach(handler -> handler.accept(notification));
        } else {
            System.out.println("No handler for type \"" + notification.getType() + "\" found.");
        }
    }
}
