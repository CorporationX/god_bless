package school.BJS2_38783;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {

    private final List<Notification> listOfNotification = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        listOfNotification.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                addNotification(new Notification(id, message));
                System.out.println("Добавлено уведомление: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void printNotification() {
        listOfNotification.forEach(System.out::println);
    }

}