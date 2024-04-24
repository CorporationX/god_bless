package sendNotifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futures.add(manager.fetchNotification("Notif " + i));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        manager.shutdown();
        manager.getNotifications()
                .forEach(notification -> System.out.printf("\nID: %d\nMessage: %s\n===========",
                        notification.getId(), notification.getMessage()));
    }
}
