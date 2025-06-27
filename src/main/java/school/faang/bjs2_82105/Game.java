package school.faang.bjs2_82105;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Game {
    private int scores;
    private int lives;
    private final Lock scoreLock = new ReentrantLock();
    private final Lock liveLock = new ReentrantLock();

    public Game(int initialLivesCount) {
        this.scores = 0;
        this.lives = initialLivesCount;
    }

    public void update(boolean playerScored, boolean playerLostLives) throws InterruptedException {
        if (playerScored) {
            try {
                scoreLock.lock();
                scores++;
                log.info("Increased score");
            } finally {
                scoreLock.unlock();
            }
        }
        if (playerLostLives) {
            if (lives - 1 > 0) {
                try {
                    liveLock.lock();
                    lives--;
                    log.info("Decreased lives");
                } finally {
                    liveLock.unlock();
                }
            } else {
                gameOver();
            }
        }
    }


    private void gameOver() throws InterruptedException {
        log.info(""" 
                Game Over...
                scores: {}
                C вас 5 тыщ""", scores);
        throw new InterruptedException();
    }

}
