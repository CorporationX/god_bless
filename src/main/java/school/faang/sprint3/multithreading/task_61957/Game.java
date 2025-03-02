package school.faang.sprint3.multithreading.task_61957;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Game {
    public static final int SLEEP_TIMEOUT = 25;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private int score;
    private int lives;
    private volatile boolean isGameOver;

    public Game() {
        score = 0;
        lives = 10;
        isGameOver = false;
    }

    public static Game startNewGame() {
        return new Game();
    }

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isGameOver) {
            return;
        }
        synchronized (lockScore) {
            if (!isGameOver && isPointsEarned) {
                score++;
                log.info("\nThe score was earned to {}", score);
            }
        }
        synchronized (lockLives) {
            if (lives <= 0) {
                return;
            }
            if (isLifeLost) {
                lives--;
                log.info("\nYou have lost one life. Now you have {} lives", lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    public void gameOver() {
        if (!isGameOver) {
            isGameOver = true;
            try {
                Thread.sleep(SLEEP_TIMEOUT);
            } catch (InterruptedException e) {
                log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            }
            System.out.printf("\nThe game is over! You have got %d points", score);
        }
    }
}
