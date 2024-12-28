package school.faang.bjs249230;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public synchronized void update(boolean earnedPoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                score++;
                log.info("Current score: {}", score);
            }
        }

        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                log.info("Current number of lives: {}", lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        log.info("The game over! Your score: {}", score);
    }
}