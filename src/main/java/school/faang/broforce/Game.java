package school.faang.broforce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 17.06.2025
 */
@Slf4j
public class Game {

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    @Getter
    private int score = 0;
    @Getter
    private int lives = 0;

    public void update(EventType eventType) {
        switch (eventType) {
            case SCORES_UP -> {
                synchronized (scoreLock) {
                    score++;
                    scoreLock.notifyAll();
                    log.info("+ 1 очко опыта");
                }
            }
            case LIVES_DOWN -> {
                synchronized (livesLock) {
                    lives++;
                    livesLock.notifyAll();
                    log.info("+ 1 потерянная единица жизни");
                }
            }
            default -> {
                try {
                    scoreLock.wait();
                    livesLock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток {} прерван", Thread.currentThread().getName(), e.getCause());
                }
            }
        }
    }
}
