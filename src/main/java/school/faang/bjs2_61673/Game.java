package school.faang.bjs2_61673;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Game {
    private int score;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private volatile boolean isGameOver = false;


    public void update(ActionType action) {
        if (isGameOver) {
            return;
        }

        switch (action) {
            case SCORE_POINT:
                synchronized (scoreLock) {
                    if (!isGameOver) {
                        score += 1;
                        log.info("Points added! New score: {}", score);
                    }
                }
                break;

            case LOSE_LIVE:
                synchronized (livesLock) {
                    if (!isGameOver) {
                        lives--;
                        log.info("Life lost! Remaining lives: {}", lives);
                        if (lives == 0) {
                            gameOver();
                        }
                    }
                }
                break;

            case KILL_ENEMY:
                synchronized (scoreLock) {
                    if (!isGameOver) {
                        score += 10;
                        log.info("Enemy killed! New score: {}", score);
                    }
                }
                break;

            default:
                log.warn("Unknown action received: {}", action);
        }
    }

    private void gameOver() {
        synchronized (livesLock) {
            if (!isGameOver) {
                isGameOver = true;
                log.warn("☠️ GAME OVER! Final score: {}", score);
            }
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
