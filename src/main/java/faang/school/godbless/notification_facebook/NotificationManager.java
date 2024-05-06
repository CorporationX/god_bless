package faang.school.godbless.notification_facebook;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Getter
public class NotificationManager {
    private List<Notification> notifications = new ArrayList<>();

    public void addNotification(Notification notification){
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(){
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                Notification notification = new Notification(notifications.size() + 1, "Новое уведомление");
                addNotification(notification);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}
