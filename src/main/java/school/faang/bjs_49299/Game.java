package school.faang.bjs_49299;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private final Object livesLock = new Object();
    @Getter
    private int score;
    @Getter
    private int lives;
    @Getter
    private boolean isRunning = true;

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update(boolean addingPoints, boolean lostOfLive) {
        synchronized (livesLock) {
            if (lives == 0 && isRunning) {
                gameOver();
            }

            if (lostOfLive && isRunning) {
                lives--;
                if (lives == 0) {
                    gameOver();
                }
                log.info("Lost live. Total: {}", lives);
            }

            if (addingPoints && isRunning) {
                score++;
                log.info("Adding points. Total: {}", score);
            }
        }
    }

    private void gameOver() {
        isRunning = false;
        log.info("Game over. Score: {}", score);
    }
}
