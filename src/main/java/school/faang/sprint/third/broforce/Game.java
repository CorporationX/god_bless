package school.faang.sprint.third.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 20;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isEarnScore, boolean isLoseLive) {
        synchronized (scoreLock) {
            if (isEarnScore) {
                score++;
            }
        }

        synchronized (livesLock) {
            if (lives == 0) {
                log.info("Game already done");
                return;
            }

            if (isLoseLive) {
                lives--;
            }

            if (lives <= 0) {
                lives = 0;
                gameOver();
            }
        }
    }

    private void gameOver() {
        log.info("Game Over, total score is {}", score);
    }
}
