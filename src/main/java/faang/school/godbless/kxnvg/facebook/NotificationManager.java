package faang.school.godbless.kxnvg.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {

    private List<Notification> notifications;

    public NotificationManager() {
        notifications = new ArrayList<>();
    }

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Notification>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futureList.add(manager.fetchNotification());
        }

        CompletableFuture<Void> allOffFutures = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        allOffFutures.join();
        manager.notifications.forEach(System.out::println);
    }

    private synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Notification> fetchNotification() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.supplyAsync(() -> {
            Notification n = new Notification(notifications.size(), "some message");
            addNotification(n);
            return n;
        });
    }
}
