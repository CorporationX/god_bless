package faang.school.godbless.faceook_notifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    static List<Notification> notificationList = new ArrayList<>();

    public static void main(String[] args) {
        List<CompletableFuture<Notification>> futureList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            futureList.add(fetchNotification());
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        allFutures.join();
        notificationList.forEach(System.out::println);
    }

    public static synchronized void addNotification(Notification notification){
        notificationList.add(notification);
    }

    public static CompletableFuture<Notification> fetchNotification(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return CompletableFuture.supplyAsync(() -> {
            Notification n = new Notification(notificationList.size(), "message");
            addNotification(n);
            return n;
        });
    }
}
