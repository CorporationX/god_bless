package school.faang.broforcebjs49421;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
    private static final Logger logger =
            LoggerFactory.getLogger(Game.class);

    private static final int INITIAL_SCORE = 0;
    private static final int LIFES_FOR_DEATH = 0;
    private static final int INITIAL_LIVES = 3;
    private static final double SCORE_PROBABILITY = 0.5;
    private static final double LIFE_LOSS_PROBABILITY = 0.3;
    private static final int GAME_LOOP_INTERVAL_MS = 1000;

    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game() {
        this.score = INITIAL_SCORE;
        this.lives = INITIAL_LIVES;
    }

    public void update(boolean scored, boolean lostLife) {
        synchronized (scoreLock) {
            if (scored) {
                score++;
                logger.info("Score increased to: {}", score);
            }

            synchronized (livesLock) {
                if (lostLife) {
                    lives--;
                    logger.info("Lives decreased to: {}", lives);
                    if (lives <= LIFES_FOR_DEATH) {
                        gameOver();
                    }
                }
            }
        }
    }

    public void gameOver() {
        logger.error("Game Over! Final score: {}", score);
    }

    public void startGame() {
        new Thread(() -> {
            while (lives > LIFES_FOR_DEATH) {
                boolean scored = Math.random() < SCORE_PROBABILITY;
                boolean lostLife = Math.random() < LIFE_LOSS_PROBABILITY;
                update(scored, lostLife);

                try {
                    Thread.sleep(GAME_LOOP_INTERVAL_MS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.warn("Game loop interrupted", e);
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
