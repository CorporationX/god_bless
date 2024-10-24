package school.faang.fourthStream.BJS2_38792;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class NotificationManager {
    private static final int SLEEP_TIME = 3_000;
    private static final int TERMINATION_SECONDS = 30;
    private final List<Notification> notifications = Collections.synchronizedList(new ArrayList<>());
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void fetchNotification() {
        log.info("У вас новое уведомление");
        sleep();
        CompletableFuture.runAsync(() -> addNotification(new Notification()), executor);
        log.info("Уведомление добавлено в список");
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Поток был прерван", e);
            Thread.currentThread().interrupt();
        }
    }

    private void addNotification(Notification notification) {
        notifications.add(notification);
    }

    private void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printNotifications() {
        notifications.forEach(notification ->
                System.out.println("ID: " + notification.getId() + ", Message: " + notification.getMessage()));
    }
}
