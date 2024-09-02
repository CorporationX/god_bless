package faang.school.godbless.sprint4.facebook;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationManager {
    @Getter
    private final List<Notification> notifications = new ArrayList<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    private int idSequence = 0;

    private void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification() {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                throw new RuntimeException("Thread interrupted!");
            }

            synchronized(notifications) {
                Notification notification = new Notification(idSequence, String.format("Some message (%d)", idSequence));
                idSequence++;
                addNotification(notification);
            }
        }, executor);
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
