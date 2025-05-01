package school.faang.bjs2_73916;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class Game {
    private int score;
    private int lives = 5;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final AtomicBoolean isRunning = new AtomicBoolean(true);

    public void update(boolean gainedScore, boolean lostLife) {
        synchronized (scoreLock) {
            if (gainedScore) {
                score++;
                log.info("Gained score to {}", score);
            }
        }
        synchronized (livesLock) {
            if (lostLife && lives > 0) {
                lives--;
                log.info("Left live to {}", lives);
            }
            if (lives == 0 && isRunning.get()) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        isRunning.set(false);
        log.info("Game over with the score {}", score);
    }

    public boolean isRunning() {
        return isRunning.get();
    }
}
