package faang.school.godbless.meta;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    void registerHandler(String type, Consumer<Notification> handler) {
        notificationMap.put(type, handler);
    }

    void sendNotification(@NonNull Notification notification) {
        Consumer<Notification> handler = notificationMap.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("No such notification type");
        }
    }
}
