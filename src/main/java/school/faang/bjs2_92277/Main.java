package school.faang.bjs2_92277;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int TIME_FOR_SLEEP = 5000;
    public static boolean isGameOver = false;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();

        executorService.execute(() -> {
            boolean isPointsAdded;
            boolean isLifeMinused;
            while (!isGameOver) {
                Random random = new Random();
                isPointsAdded = random.nextBoolean();
                isLifeMinused = random.nextBoolean();
                game.update(isPointsAdded, isLifeMinused);
            }
            try {
                Thread.sleep(TIME_FOR_SLEEP);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
    }
}
