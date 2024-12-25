package school.faang.bjs249310;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int GAME_LENGTH = 100;
    private static final int THREAD_POOL_SIZE = 10;

    private static final double EARNED_POINTS_THRESHOLD = 0.5;
    private static final double LOST_LIFE_THRESHOLD = 0.7;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < GAME_LENGTH; i++) {
            executorService.submit(() -> {
                boolean earnedPoints = Math.random() > EARNED_POINTS_THRESHOLD;
                boolean lostLife = Math.random() > LOST_LIFE_THRESHOLD;

                game.update(earnedPoints, lostLife);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Произошла ошибка во время задержки");
                }
            });
        }

        executorService.shutdown();
    }
}
