package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private static final Object scoreLock = new Object();
    private static final Object livesLock = new Object();
    private int score = 0;
    private int lives = 100;

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isPointsEarned) {
            synchronized (scoreLock) {
                score++;
                log.info("Очки увеличены, текущий счёт: {}", score);
            }
        }

        if (isLifeLost) {
            synchronized (livesLock) {
                lives--;
                log.info("Жизни уменьшены, оставшиеся жизни: {}", lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        log.info("Игра окончена! Все жизни потеряны.");
    }
}
