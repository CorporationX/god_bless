package school.faang.task4111.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NotificationManager {
    private List<Notification> notifications = new ArrayList<>();
    private ExecutorService service = Executors.newFixedThreadPool(10);

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            Notification notification = new Notification(id, message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            addNotification(notification);
        }, service);
    }

    public void shutdown() {
        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Ошибка, аварийно завершаем работу");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public void printAllNotification() {
        notifications.forEach(System.out::println);
    }
}
