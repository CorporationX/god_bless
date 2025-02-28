package broforce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Game {
    private static final Logger logger = LoggerFactory.getLogger(Game.class);
    private static final int SLEEP = 1000;
    private static final int AWAIT_TERMINATION = 60;
    private static final double GAINED_SCORE_VALUE = 0.7;
    private static final double LOST_LIFE_VALUE = 0.8;

    private static final String SCORES_INCREASED = "Scores increased: {}";
    private static final String LIVES_REMAINING = "Lives remaining: {}";
    private static final String GAME_OVER = "Game over!";
    private static final String FINAL_GAME_STATE = "Final game state : Final score: {}, Remaining lives: {}";

    private int score = 0;
    private int lives = 8;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean gameOver = false;

    public void update(boolean gainedScore, boolean lostLife) {
        if (gameOver) {
            return;
        }

        if (gainedScore) {
            synchronized (scoreLock) {
                if (!gameOver) {
                    score++;
                    logger.info(SCORES_INCREASED, score);
                }
            }
        }

        if (lostLife) {
            synchronized (livesLock) {
                if (!gameOver && lives > 0) {
                    lives--;
                    logger.info(LIVES_REMAINING, lives);
                    if (lives == 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        synchronized (scoreLock) {
            synchronized (livesLock) {
                if (!gameOver) {
                    gameOver = true;
                    logger.warn(GAME_OVER);
                }
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 50; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(SLEEP);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                boolean gainedScore = Math.random() > GAINED_SCORE_VALUE;
                boolean lostLife = Math.random() > LOST_LIFE_VALUE;
                game.update(gainedScore, lostLife);
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        logger.info(FINAL_GAME_STATE, game.score, game.lives);
    }
}