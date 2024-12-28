package school.faang.bjs250574;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {

    private List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5_000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            addNotification(new Notification(id, message));
            System.out.println("Notification with id: " + id + " has been successfully added.");
        });
    }

    public void printNotifications() {
        System.out.println("---------------------------------------------------------");
        notifications.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
    }

}
