package school.faang.bjs2_90399;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
public class Game {
    private static final int LIVES_SQUAD = 10;
    private static final int DEFAULT_SCORE = 0;
    private final Lock scoreLock = new ReentrantLock();
    private final Lock livesLock = new ReentrantLock();
    private AtomicInteger lives = new AtomicInteger(LIVES_SQUAD);
    private AtomicInteger score = new AtomicInteger(DEFAULT_SCORE);

    public void update(boolean isPointEarned, boolean isLifeLost) {
        if (isPointEarned) {
            scoreLock.lock();
            try {
                score.incrementAndGet();
                log.info("Очки увеличены, текущий счет: {}", score);
            } finally {
                scoreLock.unlock();
            }
        }
        if (isLifeLost) {
            livesLock.lock();
            try {
                lives.decrementAndGet();
                if (lives.get() <= 0) {
                    gameOver();
                    return;
                }
                log.info("Жизни уменьшены, оставшиеся жизни : {}", lives);
            } finally {
                livesLock.unlock();
            }
        }
    }

    private void gameOver() {
        log.info("Ваша игра закончилась с общим счетом счетом {}", score.get());
    }
}
