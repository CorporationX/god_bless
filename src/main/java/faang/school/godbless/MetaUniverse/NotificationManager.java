package faang.school.godbless.MetaUniverse;

import java.util.HashMap;
import java.util.function.Consumer;

public class NotificationManager {
    public NotificationManager() {
        this.handlers = new HashMap<>();
    }

    private final HashMap<String, Consumer<Notification>> handlers;
    public void registerHandler(String id, Consumer<Notification> handler) {
        handlers.put(id, handler);
    }

    public void sendNotification(Notification notification){
        handlers.get(notification.type).accept(notification);
    }
}
