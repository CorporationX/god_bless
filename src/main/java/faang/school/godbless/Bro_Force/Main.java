package faang.school.godbless.Bro_Force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game newGame = new Game();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> newGame.update());
        executor.submit(() -> newGame.update());
        executor.submit(() -> newGame.update());
        executor.shutdown();
        try {
            if (executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
