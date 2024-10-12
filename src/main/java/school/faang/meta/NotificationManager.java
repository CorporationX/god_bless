package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {

  private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();
  private final Map<String, Function<Notification, Notification>> notificationFilters = new HashMap<>();

  public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
    notificationHandlers.put(type, notificationConsumer);
  }

  public void sendNotification(Notification notification) {
    notificationHandlers.get(notification.getType()).accept(notification);
  }

  public void registerFilter(String type, Function<Notification, Notification> notificationFilter) {
    notificationFilters.put(type, notificationFilter);
  }

  public Notification filterNotification(Notification notification, String filter) {
    Function<Notification, Notification> filterHandler = notificationFilters.get(filter);
    return filterHandler.apply(notification);
  }

}
