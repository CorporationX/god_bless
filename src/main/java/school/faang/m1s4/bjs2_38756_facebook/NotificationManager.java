package school.faang.m1s4.bjs2_38756_facebook;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class NotificationManager {
    private static final long MAX_INTERRUPTION_MS = 500;
    private final List<Notification> notifications = new ArrayList<>();

    private synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message, ExecutorService threadPool) {
        return CompletableFuture.runAsync(() -> {
            sleep();
            addNotification(new Notification(id, message));
            log.info("Notification #{} has been added", id);
        }, threadPool);
    }

    public void printNotifications() {
        notifications.forEach(System.out::println);
        log.info("Total notifications: {}", notifications.size());
    }

    private void sleep() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(MAX_INTERRUPTION_MS));
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }
}
