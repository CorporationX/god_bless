package faang.school.godbless.raven;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        List<Kingdom> kingdoms = List.of(
                new Kingdom("Starks"),
                new Kingdom("Lannister"),
                new Kingdom("Targarien"),
                new Kingdom("Barateon")
        );

        List<CompletableFuture<String>> ravenFutures = kingdoms.stream().flatMap(kingdom -> kingdoms.stream()
                        .filter(anotherKingdom -> !anotherKingdom.equals(kingdom))
                        .map(anotherKingdom -> kingdom.sendMessage(anotherKingdom)))
                .toList();

        CompletableFuture.allOf(ravenFutures.toArray(CompletableFuture[]::new))
                .join();

        ravenFutures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
