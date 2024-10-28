package Sprint_4.BJS2_38935;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class NotificationManager {
    private final List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public List<Notification> getNotifications() {
        return new ArrayList<>(notifications);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(6);
                Notification notification = new Notification(id, message);
                addNotification(notification);
                System.out.println("Добавлено уведомление: " + notification);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

    }


    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            CompletableFuture<Void> future = notificationManager.fetchNotification(i, "Сообщение: " + i);
            futures.add(future);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();

        System.out.println("Список всех уведомлений: ");
        notificationManager.getNotifications().forEach(System.out::println);
    }

}
