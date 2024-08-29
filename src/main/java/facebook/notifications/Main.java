package facebook.notifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int NOTIFICATIONS_COUNT = 100;

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < NOTIFICATIONS_COUNT; i++) {
            futures.add(manager.fetchNotification());
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        manager.printAllNotifications();
    }
}
