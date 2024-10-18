package school.faang.bro_force_BJS2_37068;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static double CHANCE_EARN_SCORE = 0.5;
    private final static double CHANCE_LOOSE_LIFE = 0.7;
    private final static int LIVES_ENDED = 0;
    private final static int AWAITING_TIME = 3;

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game(0, 5);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> {
            while (game.getLives() > LIVES_ENDED) {
                boolean isScoreEarn = Math.random() > CHANCE_EARN_SCORE;
                boolean isLiveLost = Math.random() > CHANCE_LOOSE_LIFE;
                game.update(isScoreEarn, isLiveLost);
            }
        });

        executorService.shutdown();

        if (executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
            System.out.println("All tasks are terminated");
        } else {
            System.out.println("Awaiting time is over, all tasks are not terminated");
            executorService.shutdownNow();
        }
    }
}
