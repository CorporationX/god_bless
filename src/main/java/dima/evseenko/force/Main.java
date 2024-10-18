package dima.evseenko.force;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_COUNT = 10;
    private static final int UPDATES_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(0, 10);

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < UPDATES_COUNT; i++) {
            executorService.submit(() -> game.update(new Random().nextBoolean(), new Random().nextBoolean()));
        }

        executorService.shutdown();

        if (executorService.awaitTermination(100, TimeUnit.SECONDS)) {
            System.out.println(game);
        }
    }
}
