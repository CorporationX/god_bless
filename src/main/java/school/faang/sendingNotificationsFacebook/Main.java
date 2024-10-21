package school.faang.sendingNotificationsFacebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i=0; i< 100; i++) {
            futures.add(manager.fetchNotification());
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("All notifications are fetched."))
                .join();
    }
}
