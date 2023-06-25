package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {
    private final Map<String, Consumer<Notification>> data = new HashMap<>();

    public Map<String, Consumer<Notification>> getData() {
        return data;
    }

    public void registerHandler(String type,
                                Consumer<Notification> notificationConsumer) {
        data.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = null;

        try {
            notificationConsumer = data.get(notification.getType());
            notificationConsumer.accept(notification);
        } catch (NullPointerException e) {
            System.out.println("Нет такого типа нотификаций");
        }
    }
}
