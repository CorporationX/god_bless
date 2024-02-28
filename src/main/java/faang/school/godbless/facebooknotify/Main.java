package faang.school.godbless.facebooknotify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    private static NotificationManager manager = new NotificationManager();

    public static void main(String[] args) {
        List<CompletableFuture<Void>> sentNotifications = sendNotifications(10);
        CompletableFuture.allOf(sentNotifications.toArray(CompletableFuture[]::new)).join();

        manager.shutdownAndAwaitExecution(5);
        System.out.println(manager.getNotifications());
    }

    private static List<CompletableFuture<Void>> sendNotifications(int count) {
        List<CompletableFuture<Void>> sentNotifications = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manager.fetchNotification();
        }
        return sentNotifications;
    }
}