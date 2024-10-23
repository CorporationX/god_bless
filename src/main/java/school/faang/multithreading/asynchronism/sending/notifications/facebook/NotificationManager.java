package school.faang.multithreading.asynchronism.sending.notifications.facebook;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class NotificationManager {
    private static final int THREADS_COUNT = 5;
    private static final int TIME_TO_SLEEP = 1000;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

    private List<Notification> notifications = new ArrayList<>();

    public CompletableFuture<Void> fetchNotification(Integer id, String message) {
        return CompletableFuture.runAsync(
                () -> {
                    try {
                        Thread.sleep(TIME_TO_SLEEP);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    addNotification(new Notification(id, message));
                }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }

    public void printNotifications() {
        notifications.forEach(notification -> log.info("Уведомление: №{}, сообщение: {}", notification.getId(), notification.getMessage()));
    }

    private synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }
}
