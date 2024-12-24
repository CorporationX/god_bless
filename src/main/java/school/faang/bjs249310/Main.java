package school.faang.bjs249310;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int GAME_LENGTH = 100;
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < GAME_LENGTH; i++) {
            executorService.submit(() -> {
                boolean earnedPoints = Math.random() > 0.5;
                boolean lostLife = Math.random() > 0.7;

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
