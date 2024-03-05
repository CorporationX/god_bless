package faang.school.godbless.facebooknotifications3274;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Facebook {
    static final NotificationManager NOTIFICATION_MANAGER = new NotificationManager();
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        List<CompletableFuture<Notification>> futureNotifications = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            futureNotifications.add(NOTIFICATION_MANAGER.fetchNotification(new Notification("Message #" + i), EXECUTOR));
        }
        CompletableFuture.allOf(futureNotifications.toArray(CompletableFuture[]::new))
                .thenRun(() -> futureNotifications.forEach(notification -> System.out.println(getFuture(notification))))
                .thenRun(EXECUTOR::shutdown);
    }

    private static Notification getFuture(CompletableFuture<Notification> notification) {
        Notification returnable;
        try {
            returnable = notification.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return returnable;
    }
}
