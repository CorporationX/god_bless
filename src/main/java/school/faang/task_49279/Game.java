package school.faang.task_49279;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isIncreasedScore, boolean isLostLives) {
        log.info("Increased score = {}. Lost lives = {}", isIncreasedScore, isLostLives);
        synchronized (scoreLock) {
            if (isIncreasedScore) {
                score++;
                log.info("Player increased score. Score = {}", score);
            }
        }
        synchronized (livesLock) {
            if (isLostLives) {
                lives--;
                log.info("Lost lives. Lives = {}", lives);
                if (lives <= 0)  {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        throw new GameOverException();
    }
}
