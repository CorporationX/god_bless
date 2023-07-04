package faang.school.godbless.sprint4.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            futures.add(manager.fetchNotification(i, "Hello" + i));
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        for (Notification notification : manager.notifications) {
            System.out.println(String.format("id notification %s: message %s", notification.getId(), notification.getMessage()));
        }

    }
}
