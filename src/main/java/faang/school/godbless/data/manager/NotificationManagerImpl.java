package faang.school.godbless.data.manager;

import faang.school.godbless.domain.manager.NotificationManager;
import faang.school.godbless.domain.model.Notification;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class NotificationManagerImpl implements NotificationManager {

    Executor mExecutor;
    List<Notification> mNotificationList;

    public NotificationManagerImpl(@NonNull Executor mExecutor) {
        this.mExecutor = mExecutor;
        mNotificationList = new ArrayList<>();
    }

    @Override
    public synchronized void addNotification(Notification notification) {
        mNotificationList.add(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return mNotificationList;
    }

    @Override
    public CompletableFuture<Void> fetchNotification() {
        return CompletableFuture.supplyAsync(() -> {
                    long notificationId = UUID.randomUUID().getMostSignificantBits();
                    Notification notification = new Notification(
                            notificationId,
                            "some message with ID " + notificationId);

                    long timeout =  10_000; //new Random().nextInt(2001) + 1000;

                    try {
                        Thread.sleep(timeout);
                        return notification;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return null;
                },
                mExecutor
        );
    }
}
