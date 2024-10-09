package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import lombok.Getter;

@Getter
public class NotificationManager {

  private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

  public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
    notifications.put(type, notificationConsumer);
  }

  public void sendNotification(Notification notification) {
    notifications.get(notification.getType()).accept(notification);
  }

  public Notification censorNotification(Notification notification, Function<Notification, Notification> notificationFunction) {
    return notificationFunction.apply(notification);
  }
}
