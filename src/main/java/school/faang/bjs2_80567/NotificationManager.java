package school.faang.bjs2_80567;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> consumer = new HashMap<>();
    private List<String> incorrectWord = List.of("с**а", "б**");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        consumer.put(type, handler);
    }


    public void sendNotification(Notification notification) {
        for (Map.Entry<NotificationType, Consumer<Notification>> entry : consumer.entrySet()) {
            entry.getValue().accept(notification);
        }
    }

}
