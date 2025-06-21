package school.faang.bjs2_82047;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private int score = 0;
    private int lives = 9;
    private boolean isGameOver = false;

    public void update(boolean isPointEarned, boolean isLostLive) {
        if (isPointEarned) {
            synchronized (scoreLock) {
                if (!isGameOver) {
                    score++;
                    log.info("Number of points increased, current scores: {}", score);
                }
            }
        }

        if (isLostLive) {
            synchronized (livesLock) {
                if (!isGameOver) {
                    if (lives >= 1) {
                        lives--;
                        log.info("Number of lives reduced, current lives: {}", lives);
                    } else {
                        log.info("Lives are over");
                        isGameOver = true;
                        gameOver();
                    }
                }
            }
        }
    }

    public void gameOver() {
        log.info("Game over\nFinal score: {}", score);
    }

}
