package faang.school.godbless.sprint_3.multithreading_future.facebook_notifications;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class NotificationManager {
    @Getter
    private final List<Notification> notifications;
    private final AtomicInteger numberOfNotification;

    public NotificationManager() {
        this.numberOfNotification = new AtomicInteger(0);
        this.notifications = new ArrayList<>();
    }

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification() {
        String message = "Новое сообщение № " + numberOfNotification.incrementAndGet();
        Notification notification = new Notification(numberOfNotification.get(), message);
        return CompletableFuture.runAsync(() -> {
            addNotification(notification);
            int random = ThreadLocalRandom.current().nextInt(5) * 1000;
            try {
                Thread.sleep(random);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
    }
}