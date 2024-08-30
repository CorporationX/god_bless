package faang.school.godbless.BJS2_24714;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    private static final int NOTIFICATION_COUNT = 10;

    public static void main(String[] args) {

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        NotificationManager manager = new NotificationManager(new ArrayList<>());

        for (int i = 0; i < NOTIFICATION_COUNT; i++) {
            futures.add(manager.fetchNotification(new Notification(i, "message" + i)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        manager.printNotifications();

    }
}
