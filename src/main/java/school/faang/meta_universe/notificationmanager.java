package school.faang.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class notificationmanager {
    private Map<String, Consumer<notification>> HANDLERS;

    public notificationmanager() {
        HANDLERS = new HashMap<>();
    }

    public void RegisterHandler(String NotificationType, Consumer<notification> Handler) {
        HANDLERS.put(NotificationType, Handler);
    }

    public void SendNotification(notification n) {
        if (HANDLERS.containsKey(n.gettype())) {
            HANDLERS.get(n.gettype()).accept(n);
        } else {
            System.out.println("Handler not found for notification type: " + n.gettype()); }
    }
}
