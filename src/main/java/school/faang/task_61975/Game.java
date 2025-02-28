package school.faang.task_61975;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Game {
    private int score;
    private int lives;

    private final Lock scoreLock = new ReentrantLock();
    private final Lock livesLock = new ReentrantLock();
    private volatile boolean gameOverTriggered = false;

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update(boolean gainedScore, boolean lostLives) {
        if (gameOverTriggered) {
            return;
        }

        if (gainedScore) {
            scoreLock.lock();
            try {
                score++;
                log.info("Игрок заработал очки! Текущий счет: {}", score);
            } finally {
                scoreLock.unlock();
            }
        }

        if (lostLives) {
            livesLock.lock();
            try {
                lives--;
                log.info("Игрок потерял жизнь! Осталось жизней: {}", lives);
                if (lives <= 0) {
                    gameOver();
                }
            } finally {
                livesLock.unlock();
            }
        }
    }

    public void gameOver() {
        gameOverTriggered = true;
        log.info("Игра окончена! Итоговый счет: {}", score);
    }
}
