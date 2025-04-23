package school.faang.sync.bro_force;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {

    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isScoreUp, boolean isLivesDown) {
        synchronized (scoreLock) {
            if (isScoreUp) {
                score++;
                log.info("Score: {}", score);
            }
        }

        synchronized (livesLock) {
            if (isLivesDown) {
                lives--;
                log.info("Lives: {}", lives);
                checkLives();
            }
        }
    }

    private void checkLives() {
        if (lives <= 0) {
            log.info("Your lives reached {}, Game Over!", lives);
        }
    }
}
