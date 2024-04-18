package faang.school.godbless.sprint2.lambda.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private Map<String, Consumer<Notification>> typeToHandler = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        typeToHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (typeToHandler.containsKey(notification.getType())) {
            typeToHandler.get(notification.getType()).accept(notification);
        } else {
            System.out.println("No handler for type " + notification.getType() + " found.");
        }
    }
}
