package school.faang.facebook_notifications_BJS2_38766;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class NotificationManager {
    private static final int CREATING_TIME = 3000;

    private final ExecutorService executor = Executors.newCachedThreadPool();
    private List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public synchronized CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(CREATING_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    addNotification(new Notification(id, message));
                }, executor
        );
    }

    public void printNotifications() {
        notifications.forEach(System.out::println);
    }
}