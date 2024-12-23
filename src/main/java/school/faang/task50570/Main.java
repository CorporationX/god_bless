package school.faang.task50570;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        List<Notification> notifications = List.of(
                new Notification(1, "привет"),
                new Notification(2, "пока")
        );

        CompletableFuture.allOf(notifications.stream()
                .map(manager::fetchNotification)
                .toArray(CompletableFuture[]::new)).join();
    }

}
