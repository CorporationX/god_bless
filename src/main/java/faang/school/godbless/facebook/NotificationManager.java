package faang.school.godbless.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationManager {

    private final List<Notification> notifications = new ArrayList<>();

    private final long SLEEP = 1000L;

    private void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int i) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            Notification anotherNotification = new Notification(i, "Message_" + i);
            try {
                Thread.sleep(SLEEP);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            addNotification(anotherNotification);
        }, executorService);
        executorService.shutdown();
        return completableFuture;
    }

    public void printAllAppliedNotification() {
        System.out.println(notifications);
    }
}
