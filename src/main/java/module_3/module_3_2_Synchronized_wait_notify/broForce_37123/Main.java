package module_3.module_3_2_Synchronized_wait_notify.broForce_37123;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(10, 10);
        final int step = 50;
        Random random = new Random();
        Thread[] threads = new Thread[step];

        for (int i = 0; i < step; i++) {
            boolean isScoredPoints = random.nextBoolean();
            boolean lostLives = random.nextBoolean();
            threads[i] = new Thread(() -> game.update(isScoredPoints, lostLives));
        }

        for (Thread thread : threads) {
            thread.start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
