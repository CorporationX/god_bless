package faang.school.godbless.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
  public static void main(String[] args) {
    final int NOTIFICATION_LENGTH = 5;

    NotificationManager notificationManager = new NotificationManager();
    List<CompletableFuture<Notification>> futures = new ArrayList<>();

    for (int i = 0; i < NOTIFICATION_LENGTH; i++) {
      futures.add(notificationManager.fetchNotification(i+1));
    }

    CompletableFuture<Void> tasks = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));

    tasks.thenRun(() -> {
      for (CompletableFuture<Notification> future : futures) {
        try {
          Notification notification = future.get();
          System.out.println("Notification with id " + notification.getId() + " was created");
        } catch (InterruptedException | ExecutionException e) {
          throw new RuntimeException(e);
        }
      }
    }).join();
  }
}
