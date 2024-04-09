package faang.school.godbless.BJS2_5109;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
  private Map<String, Consumer<Notification>> notifications = new HashMap<>();

  public void registerHandler(String type, Consumer<Notification> consumer) {
    notifications.put(type, consumer);
  }

  public void sendNotification(Notification notification) {
    notifications.get(notification.getType()).accept(notification);
  }
}
