package faang.school.godbless.bjs2_10036;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

  private Map<String, Consumer<Notification>> notificationHandler = new HashMap<>();

  public void registerHandler(String idMessage, Consumer<Notification> consumer) {
    notificationHandler.computeIfAbsent(idMessage, value -> consumer);
  }

  public void sendNotification(Notification notification) {
    notificationHandler.get(notification.type()).accept(notification);
  }

}
