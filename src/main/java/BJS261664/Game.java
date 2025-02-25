package BJS261664;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Game {
    private Integer score = 0;
    private Integer lives = 0;
    private final Lock scoreLock = new ReentrantLock();
    private final Lock livesLock = new ReentrantLock();

    public void update(boolean isHavePoint, boolean isHaveLives) {
        if (isHavePoint) {
            scoreLock.lock();
            try {
                score++;
                log.info("Score: " + score);
            } finally {
                scoreLock.unlock();
            }
        }
        if (isHaveLives) {
            synchronized (livesLock) {
                livesLock.lock();
                try {
                    lives--;
                    log.info("Lives: " + lives);
                    if (lives <= 0) {
                        gameOver();
                    }
                } finally {
                    livesLock.unlock();
                }
            }
        }
    }

    public void gameOver() {
        log.info("Game Over");
    }
}

