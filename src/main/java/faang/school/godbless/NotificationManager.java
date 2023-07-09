package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    private List<Notification> notificationList;

    public NotificationManager() {
        notificationList = new ArrayList<>();
    }

    public synchronized void addNotification(Notification notification) {
        notificationList.add(notification);
    }

    public CompletableFuture<Void> fetchNotification() {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000); // Задержка в 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Notification notification = new Notification(notificationList.size() + 1, "New Notification");
            addNotification(notification);
        });
    }

    public List<Notification> getNotifications() {
        return notificationList;
    }
}
