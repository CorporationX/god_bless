package school.faang.bjs2_87662;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationMap = new HashMap<>();
    private final List<Function<String, String>> proofReaders = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        proofReaders.forEach(f -> notification.setMessage(f.apply(notification.getMessage())));
        notificationMap.get(notification.getType()).accept(notification);
    }

    public void addProofreader(Function<String, String> fun) {
        proofReaders.add(fun);
    }
}
