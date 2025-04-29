package school.faang.multithreading.synchronization.bjs2_73779.bro_force;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private long score = 0;
    private int lives = 10;
    private volatile boolean isRunning = true;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(long newPoint, int lostLives) {
        if (isRunning) {
            synchronized (scoreLock) {
                if (newPoint > 0) {
                    score += newPoint;
                    log.info("New point = {}, updated score = {}", newPoint, score);
                }
            }
            synchronized (livesLock) {
                if (lostLives > 0) {
                    if (lostLives >= lives) {
                        gameOver();
                    } else {
                        lives -= lostLives;
                        log.info("lostLives = {}, updated lives = {}", lostLives, lives);
                    }
                }
            }
        } else {
            log.info("Game is not running. Update is impossible");
        }
    }

    private void gameOver() {
        isRunning = false;
        log.info("Game over");
    }
}
