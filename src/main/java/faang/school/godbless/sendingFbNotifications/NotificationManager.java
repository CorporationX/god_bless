package faang.school.godbless.sendingFbNotifications;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class NotificationManager {
    private List<Notification> notifications;
    private AtomicInteger idCounter;

    public NotificationManager() {
        notifications = new ArrayList<>();
        idCounter = new AtomicInteger(0);
    }

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification() {
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                int id = idCounter.incrementAndGet();
                String message = "Новое уведомление";
                Notification newNotification = new Notification(id, message);
                addNotification(newNotification);
                completableFuture.complete(null);
            } catch (InterruptedException e) {
                completableFuture.completeExceptionally(e);
            }
        });

        return completableFuture;
    }
}
