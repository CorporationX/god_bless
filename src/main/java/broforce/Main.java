package broforce;

import lombok.NonNull;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(new Object(), new Object());
        var players = List.of(new Player("Aboba", 3), new Player("Biba", 5),
                new Player("Tank", 8), new Player("Dude", 2));
        try (ExecutorService executor = Executors.newFixedThreadPool(5)) {
            players.forEach(p -> executor.submit(() -> game.update(p)));
            executor.shutdown();
            executor.awaitTermination(30, TimeUnit.SECONDS);
        }
        printGameResult(game);
    }

    private static void printGameResult(@NonNull Game game) {
        System.out.println("Game ended");
        System.out.println("Losted lives: " + game.getLives());
        System.out.println("Getting scores: " + game.getScore());
    }
}
