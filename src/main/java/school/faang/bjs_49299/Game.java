package school.faang.bjs_49299;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private int score;
    private int lives;
    @Getter
    private boolean isRunning = true;

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update(boolean addingPoints, boolean lostOfLive) {
        synchronized (livesLock) {
            if (!isRunning) {
                return;
            }

            synchronized (scoreLock) {
                if (addingPoints) {
                    score++;
                    log.info("Adding points. Total: {}", score);
                }
            }

            if (lostOfLive) {
                lives--;
                if (lives == 0) {
                    gameOver();
                }
                log.info("Lost live. Total: {}", lives);
            }
        }
    }

    private void gameOver() {
        synchronized (livesLock) {
            isRunning = false;
            log.info("Game over. Score: {}", score);
        }
    }
}
