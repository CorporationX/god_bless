package school.faang.broforce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Danil Pudovkin
 * @since 17.06.2025
 */
@Slf4j
public class Game {

    private final Lock scoreLock = new ReentrantLock();
    private final Lock livesLock = new ReentrantLock();
    @Getter
    private int score = 0;
    @Getter
    private int lives = 0;

    public void update(EventType eventType) {
        switch (eventType) {
            case SCORES_UP -> tryLockAndDo(scoreLock, () -> {
                score++;
                log.info("+ 1 очко опыта");
            });
            case LIVES_DOWN -> tryLockAndDo(livesLock, () -> {
                lives++;
                log.info("+ 1 потерянная единица жизни");
            });
            default -> log.warn("Неизвестный тип события {}", eventType);
        }
    }

    private void tryLockAndDo(Lock lock, Runnable action) {
        boolean success = false;
        while (!success) {
            if (lock.tryLock()) {
                try {
                    action.run();
                    success = true;
                } finally {
                    lock.unlock();
                }
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
