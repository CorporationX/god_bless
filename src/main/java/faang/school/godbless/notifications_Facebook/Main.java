package faang.school.godbless.notifications_Facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futures.add(manager.fetchNotifications());
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        manager.getNotifications().forEach(i -> System.out.println(i.getId() + ": " + i.getMessage()));
    }
}
