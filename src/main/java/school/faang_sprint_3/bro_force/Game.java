package school.faang_sprint_3.bro_force;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private int score = 0;
    private int lives = 10;

    public void update(boolean earnPoint, boolean looseLive) {
        synchronized (scoreLock) {
            if (earnPoint) {
                score++;
                log.info("Earn point:{}", score);
            }
        }
        synchronized (livesLock) {
            if (looseLive) {
                lives--;
                log.info("Loose live:{}", lives);
            }
        }
        gameOver();
    }

    private void gameOver() {
        if (lives <= 0) {
            log.info("No lives left. Game Over!");
            log.info("Your score: {}", score);
        }
    }
}
