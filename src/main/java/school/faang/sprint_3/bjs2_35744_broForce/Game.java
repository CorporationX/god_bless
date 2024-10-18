package school.faang.sprint_3.bjs2_35744_broForce;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Game {
    private static final double SCORE_INCREASE_PROBABILITY = 0.8;
    private static final double LIVE_LOST_PROBABILITY = 0.3;
    private static final Random RANDOM = new Random();
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private volatile boolean isGameOver = false;
    private int score;
    private int lives;

    public Game(int lives) {
        this.lives = lives;
        this.score = 0;
    }

    private void update(boolean isScoreIncreased, boolean isLiveLost) {
        synchronized (scoreLock) {
            if (isScoreIncreased) {
                score++;
                log.info("+1! Current score: {}", score);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    log.error("Error while increasing score.");
                    throw new RuntimeException(e);
                }
            }
        }

        synchronized (livesLock) {
            if (isLiveLost) {
                lives--;
                log.info("Oops. You died =( lives {}", lives);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    log.error("Error while decreasing lives.");
                    throw new RuntimeException(e);
                }
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        log.info("Better luck next time! Total score: {}", score);
        Thread.currentThread().interrupt();
    }

    private boolean randomScoreIncrease() {
        return RANDOM.nextDouble() < SCORE_INCREASE_PROBABILITY;
    }

    private boolean randomLiveLost() {
        return RANDOM.nextDouble() < LIVE_LOST_PROBABILITY;
    }

    public void startGame() {
        while (!isGameOver) {
            boolean isScoreIncreased = randomScoreIncrease();
            boolean isLiveLost = randomLiveLost();
            update(isScoreIncreased, isLiveLost);
        }
    }
}
