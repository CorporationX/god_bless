package school.faang.bro.force;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Game {
    private static final int COUNT_THREAD = 10;
    private static final int TIME_FOR_WAITING = 5;
    private int score = 0;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isPointsEarned) {
            synchronized (scoreLock) {
                try {
                    score++;
                    log.info("Очки увеличены, текущий счёт: {}", score);
                } finally {
                    scoreLock.notify();
                }
            }
        }

        if (isLifeLost) {
            synchronized (livesLock) {
                try {
                    if (lives <= 0) {
                        gameOver();
                    }
                    lives--;
                    log.info("Жизни уменьшены, оставшиеся жизни: {}", lives);
                } finally {
                    livesLock.notify();
                }
            }
        }
    }

    public void gameOver() {
        log.info("GAMEOVER!");
        System.exit(0);
    }

    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                boolean earnedPoints = Math.random() < 0.5;
                boolean lostLife = Math.random() < 0.3;

                game.update(earnedPoints, lostLife);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_FOR_WAITING, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
