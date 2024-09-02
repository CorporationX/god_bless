package faang.school.godbless.facebook;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Getter
public class NotificationManager {
    private final List<Notification> notifications = new LinkedList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Adding notification failed");
            }
            addNotification(new Notification(id, message));
        });
    }

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Void>> futures = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            futures.add(manager.fetchNotification(i, "Message of notification with id " + i));
        }
        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).get();
            System.out.println("All notifications added");
            System.out.println(manager.getNotifications());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Fetching notifications failed");
        }
    }
}
