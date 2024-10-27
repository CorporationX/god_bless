package school.faang.sendingfbnotifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            CompletableFuture<Void> future = manager.fetchNotification(i, "Уведомление #" + i);
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("\nВсе уведомления:");
        manager.displayNotifications();
        manager.shutdown();
    }
}
