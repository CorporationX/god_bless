package faang.school.godbless.notifications;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class NotificationManager {
    private List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Notification> fetchNotification(Notification notification) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            addNotification(notification);

            return notification;
        }, executorService);
    }
}
