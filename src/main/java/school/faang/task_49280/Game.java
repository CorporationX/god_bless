package school.faang.task_49280;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                score++;
                log.info("Points increased, current score: {}", score);
            }
        }

        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                log.info("Lives lost, current number of lives: {}", lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    public void gameOver() {
        log.info("Game is over! Score: {}", score);
    }
}
