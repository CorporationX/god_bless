package org.example.service.facebookNotification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.facebookNotification.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationManager {
    List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.info(e.getMessage());
            }
            Notification notification = new Notification(id, message);
            addNotification(notification);
            executorService.shutdown();
            return null;
        }, executorService);
    }
}
