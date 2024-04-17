package faang.school.godbless.InterfacesLambda.MetaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {
    private final Map<String, Consumer<Notification>> NOTIFICATION_HANDLERS = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        NOTIFICATION_HANDLERS.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        if (NOTIFICATION_HANDLERS.containsKey(type)) {
            NOTIFICATION_HANDLERS.get(type).accept(notification);
        } else {
            System.out.println(type + " не найден!");
        }
    }

}
