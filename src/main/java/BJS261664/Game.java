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

    public void update(boolean havePoint, boolean haveLives) {
        if (havePoint) {
            scoreLock.lock();
            try {
                score++;
                System.out.println("Score: " + score);
            } finally {
                scoreLock.unlock();
            }
        }
        if (haveLives) {
            synchronized (livesLock) {
                livesLock.lock();
                try {
                    lives--;
                    System.out.println("Lives: " + lives);
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
        System.out.println("Game Over");
    }
}

