package school.faang.metaworld.maincode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> handlers = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> consumer) {
        handlers.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("для этого типа не зарегестрирован обработчик");
        }
    }
}
