package faang.school.godbless.notifications_on_facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NotificationManager {
    private final List<Notification> notifications = new ArrayList<>();
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(5);

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Notification> fetchNotification(Notification notification) {
        int random = new Random().nextInt(7);

        System.out.println("Задача " + notification.getMessage() + " выполняется " + random + " секунд");

        CompletableFuture<Notification> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Задача " + notification.getMessage() + " выполнена");
            addNotification(notification);

            EXECUTOR_SERVICE.shutdown();

            return notification;
        }, EXECUTOR_SERVICE);

        return completableFuture;
    }

    public void printNotifications() {
        System.out.println("Метод printNotifications начал работать");
        notifications.forEach(System.out::println);
    }
}