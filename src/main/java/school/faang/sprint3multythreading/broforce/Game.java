package school.faang.sprint3multythreading.broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;

    private final Lock scoreLock = new ReentrantLock();
    private final Lock livesLock = new ReentrantLock();

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
                if (lives > 0) {
                    lives--;
                    log.info("Жизни уменьшены, оставшиеся жизни: {}", lives);
                } else {
                    gameOver();
                }
            } finally {
                livesLock.unlock();
            }
        }
    }

    public void gameOver() {
        log.info("Iгра завершена. Жизней: {}", lives);
    }
}