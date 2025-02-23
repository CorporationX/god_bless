package school.faang.task_61762;

import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0; // Общий счёт игры
    private int lives = 10; // Начальное количество жизней

    private final ReentrantLock scoreLock = new ReentrantLock();
    private final ReentrantLock livesLock = new ReentrantLock();

    public void update(Boolean isPointsEarned, Boolean isLiveLost) {
        if (isPointsEarned) {
            scoreLock.lock();
            try {
                score++;
                log.info("Очки увеличены, текущий счёт: " + score);
            } finally {
                scoreLock.unlock();
            }
        }
        if (isLiveLost) {
            livesLock.lock();
            try {
                lives--;
                log.info("Жизни уменьшены, оставшиеся жизни: " + lives);
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
