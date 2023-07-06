package faang.school.godbless.facebook;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Getter
public class NotificationManager {
    private final List<Notification> notificationList = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notificationList.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(String message) {
        return CompletableFuture.runAsync(() -> addNotification(new Notification(notificationList.size(), message)));
    }
}
