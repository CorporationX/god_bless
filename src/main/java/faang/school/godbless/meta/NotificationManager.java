package faang.school.godbless.meta;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
@ToString
public class NotificationManager {
    private final Map<String, Consumer<Notification>> Hendler = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        Hendler.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        Hendler.get(notification.getType()).accept(notification);
    }
}
