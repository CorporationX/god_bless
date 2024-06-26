package faang.school.godbless.domain.manager;

import faang.school.godbless.domain.model.Notification;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface NotificationManager {
    void addNotification(Notification notification);
    List<Notification> getAllNotifications();
    CompletableFuture<Void> fetchNotification();
}
