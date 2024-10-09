package Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationHendlerMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        notificationHendlerMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        notificationHendlerMap.get(type).accept(notification);
    }

    public void filter(String message, Function<String, String> filter) {
        System.out.println(filter.apply(message));
    }
}
