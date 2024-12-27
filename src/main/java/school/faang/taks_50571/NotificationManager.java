package school.faang.taks_50571;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    List<Notification> notificationList = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notificationList.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String massage) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                Notification notification = new Notification(id, massage);
                addNotification(notification);
                System.out.println("Добавлено новое уведомление с данными id = " + id + " и сообщением: " + massage);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(e.getStackTrace());
            }
        });
    }

    public void printNotifications() {
        notificationList.forEach(notification ->
                System.out.println("ID: " + notification.getId() + ", Message: " + notification.getMassage()));
    }
}
