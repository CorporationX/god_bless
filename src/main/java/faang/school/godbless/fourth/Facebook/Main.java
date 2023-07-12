package faang.school.godbless.fourth.Facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        List<String> messages = List.of(
                "You've got a message",
                "Confirm your e-mail",
                "Do you want to play Tyuryaga?"
        );

        for (String message : messages) {
            futures.add(manager.fetchNotification(message));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenAccept(v -> System.out.println(manager.getNotifications()))
                .join();
    }
}
