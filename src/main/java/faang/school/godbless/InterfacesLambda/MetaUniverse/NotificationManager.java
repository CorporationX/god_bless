package faang.school.godbless.InterfacesLambda.MetaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        notificationHandlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        if (notificationHandlers.containsKey(type)) {
            notificationHandlers.get(type).accept(notification);
        } else {
            System.out.println(type + " не найден!");
        }
    }

}
