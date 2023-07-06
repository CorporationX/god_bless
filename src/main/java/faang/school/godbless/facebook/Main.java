package faang.school.godbless.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        List<String> messages = List.of(
                "Привет",
                "Пока",
                "Как дела?"
        );

        for (String message : messages) {
            futures.add(notificationManager.fetchNotification(message));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenAccept(v -> {
                            for (int i = 0; i < notificationManager.getNotificationList().size(); i++) {
                                System.out.println(notificationManager.getNotificationList().get(i).getMessage());
                            }
                        }
                )
                .join();
    }
}
