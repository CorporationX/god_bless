package faang.school.godbless.FacebookSpam;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    @Getter
    private List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(Notification notification) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(4) * 1000);
                addNotification(notification);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
