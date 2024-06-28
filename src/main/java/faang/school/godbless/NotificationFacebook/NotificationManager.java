package faang.school.godbless.NotificationFacebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class NotificationManager {
    private static final int COUNT_THREAD = 4;
    private final ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);
    private List<Notification> notifications = new ArrayList<>();

    public List<Notification> getAllNotifications() {
        return notifications;
    }

    public void finalNot(int item) {
        CompletableFuture
                .allOf(IntStream
                        .rangeClosed(1, item)
                        .mapToObj(this::fetchNotification)
                        .toArray(CompletableFuture[]::new))
                .join();
    }

    public void shutdownCall() {
        executorService.shutdown();
    }

    private CompletableFuture<Void> fetchNotification(int id) {
        return CompletableFuture.runAsync(() ->
                addNotification(new Notification(id, "Сообщение" + id)), executorService);
    }


    private void addNotification(Notification newNotification) {
        synchronized (notifications) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(4));
            } catch (InterruptedException e) {
                throw new RuntimeException("Ошибка в добавлении уведомления в список");
            }
            notifications.add(newNotification);

        }
    }
}
