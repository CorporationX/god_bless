package school.faang.facebook_notifications_BJS2_38766;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationManager {
    private List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public synchronized CompletableFuture<Void> fetchNotification(int id, String message) {
        final int CREATING_TIME = 3000;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> result = CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(CREATING_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    addNotification(new Notification(id, message));
                }, executor
        );
        executor.shutdown();
        return result;
    }

    public void printNotifications() {
        notifications.forEach(System.out::println);
    }
}