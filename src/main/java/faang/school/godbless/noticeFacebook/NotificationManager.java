package faang.school.godbless.noticeFacebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    private static List<Notification> notifications = new ArrayList<>();

    public static synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public static CompletableFuture<Void> fetchNotification(int i, String message) {
        return CompletableFuture.runAsync(() -> addNotification(new Notification(i, message)));
    }

    public static void main(String[] args) {
        List<CompletableFuture<Void>> futuresList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futuresList.add(fetchNotification(i, "Notification №" + i));
        }
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[0]));
        allFutures.join();

        notifications.forEach(notification -> System.out.println(notification.getMessage()));
    }
}
