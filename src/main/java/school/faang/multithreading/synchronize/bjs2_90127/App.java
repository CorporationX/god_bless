package school.faang.multithreading.synchronize.bjs2_90127;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Object scoreLock = new Object();
        Object livesLock = new Object();

        Game game = new Game(scoreLock, livesLock);

        for (int i = 0; i < 20; i++) {
            game.update();
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(15, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}