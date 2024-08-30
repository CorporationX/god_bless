package faang.school.godbless.sprint4.facebook;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationManager {
    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    private int ID_SEQUENCE = 0;
    @Getter
    private final List<Notification> notifications = new ArrayList<>();

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
                Notification notification = new Notification(ID_SEQUENCE, String.format("Some message (%d)", ID_SEQUENCE));
                ID_SEQUENCE++;
                addNotification(notification);
            }
        }, executor);
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
