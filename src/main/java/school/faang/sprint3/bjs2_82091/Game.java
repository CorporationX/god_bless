package school.faang.sprint3.bjs2_82091;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private static final int THREAD_BATCH = 5;

    private int score = 0;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private void update(boolean isPointsEarned, boolean isLiveLost) {
        if (isLiveLost) {
            synchronized (livesLock) {
                if (lives <= 0) {
                    gameOver();
                } else {
                    lives--;
                }
            }
        }
        if (isPointsEarned) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Текущий счет: " + score);
            }
        }
    }

    public void gameOver() {
        System.out.println("Счет: " + score);
    }

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_BATCH);
        for (int i = 1; i < 50; i++) {
            executor.execute(() -> game.update(
                    ThreadLocalRandom.current().nextBoolean(),
                    ThreadLocalRandom.current().nextBoolean()
            ));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
