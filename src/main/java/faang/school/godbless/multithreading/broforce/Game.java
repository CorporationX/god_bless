package faang.school.godbless.multithreading.broforce;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Getter
public class Game {
    private int score;
    private int lives;
    private volatile boolean isGameOver;
    private static final int LIVES_COUNT = 5;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game() {
        lives = LIVES_COUNT;
    }

    public void startGame() {
        while (!isGameOver) {
            update();
        }
    }

    /* Теперь игрок случайно либо умирает, либо зарабатывает очки.*/
    private void update() {
        if (new Random().nextBoolean()) {
            synchronized (scoreLock) {
                if (lives == 0) {
                    isGameOver = true;
                    return;
                }
                score++;
                System.out.printf("Score: %s Lives: %s | Player: (%s)\n", score, lives, Thread.currentThread().getName());
            }
        } else {
            synchronized (livesLock) {
                if (lives >= 1) {
                    lives--;
                    System.out.printf("Died Player: (%s)\n", Thread.currentThread().getName());
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void gameOver() {
        System.out.println("Game over! | " + Thread.currentThread().getName());
    }
}
