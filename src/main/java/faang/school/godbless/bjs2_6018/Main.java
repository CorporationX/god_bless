package faang.school.godbless.bjs2_6018;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        NotificationManager manager = new NotificationManager();

        List<CompletableFuture<Notification>> futures = new ArrayList<>();

        for (long i = 0; i < 10; i++) {
            futures.add(manager.fetchNotification(i, "Message-" + i));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        manager.printNotifications();
    }
}
