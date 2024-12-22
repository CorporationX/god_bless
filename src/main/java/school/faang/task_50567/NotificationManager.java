package school.faang.task_50567;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class NotificationManager {
    private static List<Notification> notifications = new ArrayList<>();
    private static AtomicInteger counter = new AtomicInteger();
    private static final int SLEEP_TIME = 3000;

    public synchronized Notification addNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Error : 15, NotificationManager");
        }
        notifications.add(notification);
        return notification;
    }

    public CompletableFuture<Notification> fetchNotification(ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int counterAndIncrement = counter.getAndIncrement();
                Notification notification =
                        new Notification(counterAndIncrement, "notification{" + counterAndIncrement + "}");
                System.out.println("Sending notification : " + notification);
                Thread.sleep(SLEEP_TIME);
                System.out.println("Notification was successfully sent : " + notification);
                return addNotification(notification);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);
    }

    public void printNotifications() {
        notifications
                .forEach(System.out::println);
    }
}
