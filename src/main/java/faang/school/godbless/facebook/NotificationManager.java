package faang.school.godbless.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
  private List<Notification> notifications = new ArrayList<>();

  public synchronized void addNotification(Notification notification) {
    notifications.add(notification);
  }

  public CompletableFuture<Notification> fetchNotification(int id) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.printf(e.toString());
      }

      Notification notification = new Notification(String.valueOf(id), "New notification " + id);

      addNotification(notification);
      return notification;
    });
  }
}
