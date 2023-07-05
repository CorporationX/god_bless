package sprint5.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Facebook {
    public static void main(String[] args) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        NotificationManager manager = new NotificationManager();

        for (int i = 0; i < 10; i++) {
            futures.add(manager.fetchNotification("Message number: " + i));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println(manager.getNotifications());
    }
}
