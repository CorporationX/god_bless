package school.faang.task_49311;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int NUM_THREAD = 100;

    public static void main(String[] args) {
        Game game = new Game();
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < NUM_THREAD; i++) {
            boolean earnedPoints = random.nextBoolean();
            boolean lostLife = random.nextBoolean();

            executor.submit(() -> updateGame(game, earnedPoints, lostLife));
        }
        executor.shutdown();
    }

    private static void updateGame(Game game, boolean earnedPoints, boolean lostLife) {
        game.update(earnedPoints, lostLife);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            log.error("Поток был прерван при выполнеии метода sleep()", e);
            Thread.currentThread().interrupt();
        }
    }
}
