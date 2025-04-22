package school.faang.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationTypeConsumerMap = new HashMap<>();
    
}
