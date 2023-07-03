package faang.school.godbless.sprint5.Multithreading_Async.task9;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Getter
public class NotificationManager {

    List<Notification> notifications  = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    private CompletableFuture<Notification> fetchNotification(Notification notification) {
        try {
            TimeUnit.MICROSECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CompletableFuture<Notification> future = CompletableFuture.supplyAsync(() -> {
            addNotification(notification);
            return notification;
        });
        return future;
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        CompletableFuture<Notification>[] notificationCompletableFuture = new CompletableFuture[5];
        for (int i = 0; i < 5; i++) {
            notificationCompletableFuture[i] = notificationManager.fetchNotification(new Notification(i, "notification " + i));
        }

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(notificationCompletableFuture);

        voidCompletableFuture.thenAccept(f -> {
            Arrays.stream(notificationCompletableFuture)
                    .map(c -> {
                        try {
                            return c.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .forEach(System.out::println);
        });

    }
}
