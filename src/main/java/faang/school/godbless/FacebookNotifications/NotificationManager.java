package faang.school.godbless.FacebookNotifications;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
@Data
public class NotificationManager {
    private List<Notification> notificationList = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notificationList.add(notification);
    }

    public CompletableFuture<Void> fetchNotification() {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            addNotification(
                new Notification(new Random().nextInt(), String.valueOf(new Random().nextInt())));});
    }
}
