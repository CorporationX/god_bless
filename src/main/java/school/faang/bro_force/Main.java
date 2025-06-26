package school.faang.bro_force;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TIME_OUT = 10;

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i <= 10; i++) {
            if (game.getLives() < 0) {
                break;
            }
            int score = random.nextInt(0, 1000);
            int live = 1;
            executorService.submit(() -> game.update(score, live));
        }
        executorService.shutdown();
        executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
    }
}