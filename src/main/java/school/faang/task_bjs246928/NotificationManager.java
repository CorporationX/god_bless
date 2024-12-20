package school.faang.task_bjs246928;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> typeMessageConnect = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        typeMessageConnect.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (typeMessageConnect.containsKey(notification.getType())) {
            typeMessageConnect.get(notification.getType()).accept(notification);
        } else {
            throw new IllegalArgumentException("обработка данного типа нотификаций не поддерживается");
        }
    }
}
