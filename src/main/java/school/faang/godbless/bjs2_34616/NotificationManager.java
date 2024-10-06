package school.faang.godbless.bjs2_34616;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

  private final Map<String, Consumer<Notification>> notificationTypeHandlersMap = new HashMap<>();

  public void registerHandler(String type, Consumer<Notification> consumer) {
    notificationTypeHandlersMap.put(type, consumer);
  }

  public void sendNotification(Notification notification) {
    if (notificationTypeHandlersMap.containsKey(notification.getType())) {
      notificationTypeHandlersMap.get(notification.getType()).accept(notification);
    }
  }
}
