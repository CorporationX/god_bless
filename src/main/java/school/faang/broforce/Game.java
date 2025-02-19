package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private static final Object LOCK_SCORE = new Object();
    private static final Object LOCK_LIVES = new Object();
    private static final int COUNT_GAME_OVER_LIVES = 0;
    private static final int DEFAULT_SCORE = 0;
    private static final int DEFAULT_LIVES = 3;
    private static final int MAX_VALUE_EXECUTION = 500;
    private static final int MIN_VALUE_EXECUTION = 300;

    private int score = DEFAULT_SCORE;
    private int lives = DEFAULT_LIVES;

    public synchronized void update(boolean isLostLife) throws InterruptedException {
        Thread.sleep((long) (Math.random() * MAX_VALUE_EXECUTION + MIN_VALUE_EXECUTION));
        if (!isLostLife) {
            score++;
            printStatistics();
        } else {
            lives--;
            printStatistics();
            if (lives == COUNT_GAME_OVER_LIVES) {
                gameOver();
            }
        }
    }

    private void gameOver() throws InterruptedException {
        Thread.sleep((long) (Math.random() * MIN_VALUE_EXECUTION));
        log.info("Game over with score: {}", score);
        score = DEFAULT_SCORE;
        lives = DEFAULT_LIVES;
        log.info("New game started with score: {}, and lives: {}", score, lives);
        LOCK_SCORE.notify();
        LOCK_LIVES.notify();
    }

    private void printStatistics() {
        log.info("Score: {}, lives: {}", score, lives);
    }
}
