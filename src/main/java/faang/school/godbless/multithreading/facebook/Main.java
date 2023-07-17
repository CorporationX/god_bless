package faang.school.godbless.multithreading.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Notification>> notifications = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            notifications.add(manager.fetchNotification());
        }

        CompletableFuture.allOf(notifications.toArray(new CompletableFuture[0]))
                .thenRun(() -> notifications.forEach(n -> {
                    try {
                        System.out.println(n.get());
                    } catch (ExecutionException | InterruptedException e) {
                        log.error(e.getMessage());
                    }
                }))
                .join();
    }
}
