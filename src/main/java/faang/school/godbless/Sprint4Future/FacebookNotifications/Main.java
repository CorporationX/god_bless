package faang.school.godbless.Sprint4Future.FacebookNotifications;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Notification notification = new Notification("1");
        Notification notification1 = new Notification("2");
        Notification notification2 = new Notification("3");
        Notification notification3 = new Notification("4");
        Notification notification4 = new Notification("5");

        NotificationManager notificationManager = new NotificationManager();
        CompletableFuture<Notification> completableFuture = notificationManager.fetchNotification(notification);
        CompletableFuture<Notification> completableFuture1 = notificationManager.fetchNotification(notification1);
        CompletableFuture<Notification> completableFuture2 = notificationManager.fetchNotification(notification2);
        CompletableFuture<Notification> completableFuture3 = notificationManager.fetchNotification(notification3);
        CompletableFuture<Notification> completableFuture4 = notificationManager.fetchNotification(notification4);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture
                .allOf(completableFuture, completableFuture1, completableFuture2, completableFuture3, completableFuture4);

        voidCompletableFuture.thenAccept((v) -> {
            notificationManager.getNotifications().forEach(System.out::println);
        });
    }
}
