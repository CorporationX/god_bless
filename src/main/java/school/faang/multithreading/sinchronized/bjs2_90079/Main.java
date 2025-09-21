package school.faang.multithreading.sinchronized.bjs2_90079;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TIME_DELAY = 1; // секундная задержка имитации игры

    public static void main(String[] args) {
        Game game = new Game();

        Random random = new Random();
        while (game.getLives() > 0) {
            boolean isPointsEarned = random.nextBoolean();
            boolean isLifeLost = random.nextInt(100) < 20;

            Thread thread = new Thread(() -> game.update(isPointsEarned, isLifeLost));
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(TIME_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
