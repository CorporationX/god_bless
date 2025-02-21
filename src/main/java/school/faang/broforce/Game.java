package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private static Object scoreLock = new Object();
    private static Object livesLock = new Object();
    private int score = 0;
    private int lives = 100;

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isPointsEarned) {
            scoreLock.lock();
            try {
                score++;
                log.info("Очки увеличены, текущий счёт: {}", score);
            } finally {
                scoreLock.unlock();
            }
        }

        if (isLifeLost) {
            livesLock.lock();
            try {
                lives--;
                log.info("Жизни уменьшены, оставшиеся жизни: {}", lives);
                if (lives <= 0) {
                    gameOver();
                }
            } finally {
                livesLock.unlock();
            }
        }
    }

    private void gameOver() {
        log.info("Игра окончена! Все жизни потеряны.");
    }
}
