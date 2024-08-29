package faang.school.godbless.BJS2_24920;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@RequiredArgsConstructor
public class NotificationManager {
    private final ExecutorService executor;
    private ConcurrentLinkedQueue<Notification> notifications = new ConcurrentLinkedQueue<>();

    public CompletableFuture<Notification> fetchNotification() {
        var random = ThreadLocalRandom.current();
        var notification = new Notification(random.nextInt(), Integer.toString(random.nextInt()));
        return CompletableFuture.supplyAsync(() ->
                addNotification(notification), executor);
    }

    public Notification addNotification(Notification notification) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        notifications.add(notification);
        return notification;
    }
}
