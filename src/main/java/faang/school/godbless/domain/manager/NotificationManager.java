package faang.school.godbless.domain.manager;

import faang.school.godbless.domain.model.Notification;

import java.util.concurrent.CompletableFuture;

public interface NotificationManager {
    void addNotification(Notification notification) throws InterruptedException;

    CompletableFuture<Notification> fetchNotification();
}
