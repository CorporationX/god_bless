package faang.school.godbless.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final static Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notificationHandlers.containsKey(notification.getType())) {
            Consumer<Notification> output = notificationHandlers.get(notification.getType());
            output.accept(notification);
        } else {
            System.out.println("There is no handler for the notification" +
                    " type sent in the system, we will definitely add it soon");// написал что
            // добавим из-за того что запрос летит с фронта, значит данный обработчик должен быть
            // в скором времени
        }
    }
}