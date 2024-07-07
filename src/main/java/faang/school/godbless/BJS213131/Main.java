package faang.school.godbless.BJS213131;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        List<Gamer> gamers = game.createGamers();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        gamers.forEach(gamer -> executor.execute(() -> game.update(gamer, executor)));

        executor.shutdown();


        try {
            if (!executor.awaitTermination(15, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted while completing executor", e);
        } finally {
            executor.shutdownNow();
        }
    }
}
