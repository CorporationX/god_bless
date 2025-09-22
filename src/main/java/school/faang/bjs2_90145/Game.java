package school.faang.bjs2_90145;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;
    private volatile boolean isGameRunning = true;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (!isGameRunning) {
            return;
        }
        if (isPointsEarned) {
            synchronized (scoreLock) {
                score++;
                log.info("Очки увеличены, текущий счёт: {}", score);
            }
        }

        if (isLifeLost) {
            synchronized (livesLock) {
                if (lives > 0) {
                    lives--;
                    log.info("Жизни уменьшены, оставшиеся жизни: {}", lives);
                    if (lives <= 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        isGameRunning = false;
        log.info("Игра окончена! Все жизни потеряны.");
    }
}
