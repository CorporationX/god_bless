package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {
  private final Map<String, Consumer<Notification>> mapTypeToHandler = new HashMap<String, Consumer<Notification>>();

  public Map<String, Consumer<Notification>> getMapTypeToHandler() {
    return mapTypeToHandler;
  }

  public void registerHandler(String id, Consumer<Notification> consumer) {
    mapTypeToHandler.put(id, consumer);
  }

  public void sendNotification(Notification notification) {
    String notificationType = notification.getType();
    if (mapTypeToHandler.containsKey(notificationType)) {
      mapTypeToHandler.get(notificationType).handle(notification);
    };
  }
}
