package faang.school.godbless.NotificationFacebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class NotificationManager {
    private static final int COUNT_THREAD = 4;
    private final ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);
    private List<Notification> notifications = new ArrayList<>();

    public List<Notification> getAllNotifications() {
        return notifications;
    }

    public void finalNot(int item) {
        List<CompletableFuture<Void>> transactionWait = new ArrayList<>();
        for (int i = 1; i <= item; i++) {
            transactionWait.add(fetchNotification(i));
        }
        CompletableFuture.allOf(transactionWait.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();
    }

    private CompletableFuture<Void> fetchNotification(int id) {
        return CompletableFuture.runAsync(() ->
                addNotification(new Notification(id, "Сообщение" + id)), executorService);
    }


    private void addNotification(Notification newNotification) {
        synchronized (notifications) {
            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(4));
            } catch (InterruptedException e) {
                throw new RuntimeException("Ошибка в добавлении уведомления в список");
            }
            notifications.add(newNotification);

        }
    }
}
