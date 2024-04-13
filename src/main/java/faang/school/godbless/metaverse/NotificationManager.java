package faang.school.godbless.metaverse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class NotificationManager {

    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String identifier, Consumer<Notification> handler) {
        handlers.put(identifier, handler);
    }

    public void sendNotification(Notification notification) {
        System.out.println(handlers.get(notification.getType()));
    }
}