package Multithreading.bc3332_Sending_Notifications_to_Facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationManager {
    List<Notification> notifications = new ArrayList<>();
    private int id = 1;

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Notification> fetchNotification() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Notification> completableFuture = CompletableFuture
                .supplyAsync(() -> {
                    Notification notification = new Notification(id, "Message" + id++);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    addNotification(notification);
                    return notification;
                }, executorService);

        executorService.shutdown();

        return completableFuture;
    }

}
