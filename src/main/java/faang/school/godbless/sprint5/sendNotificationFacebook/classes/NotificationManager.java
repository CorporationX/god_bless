package faang.school.godbless.sprint5.sendNotificationFacebook.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class NotificationManager {
    private final List<Notification> notifications = new ArrayList<>();

    private synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }


    public CompletableFuture<Notification> fetchNotifications(Notification notification) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            addNotification(notification);
            return notification;
        });
    }

    public List<Notification> getNotifications() {
        return new ArrayList<>(notifications);
    }
}