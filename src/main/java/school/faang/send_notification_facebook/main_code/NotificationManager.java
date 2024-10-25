package school.faang.send_notification_facebook.main_code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NotificationManager {
    private static final int THREAD_COUNT = 5;

    private ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
    private List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void fetchAllNotifications() {
        List<CompletableFuture<Notification>> notificationFutures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            notificationFutures.add(fetchNotification(i, "message_" + i));
        }

        CompletableFuture<Void> allNotificationFutures =
                CompletableFuture.allOf(notificationFutures.toArray(CompletableFuture[]::new))
                        .thenRun(() -> {
                            notifications.forEach(notification ->
                                    System.out.println("id " + notification.getId() + " message " + notification.getMessage()));
                        });

        allNotificationFutures.join();
    }

    private CompletableFuture<Notification> fetchNotification(int id, String message) {
        CompletableFuture<Notification> notificationFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException("Ошибка при попытке добавить уведомление" + e);
            }

            Notification notification = new Notification(id, message);

            addNotification(notification);
            System.out.println("Добавлено уведомление " + notification.getMessage());

            return notification;
        }, executor);
        return notificationFuture;
    }

    public void shutdown() {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка при попытке закрыть пулл потоков");
            executor.shutdownNow();
        }
    }
}
