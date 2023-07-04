package faang.school.godbless.multithreading.broforce;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
public class Game {
    private int score;
    private int lives;
    private volatile boolean isGameOver;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game() {
        score = 0;
        lives = 5;
        isGameOver = false;
    }

    public void startGame() {
        while (!isGameOver) {
            update();
        }
        gameOver();
    }

    /* Будем считать что потоки это игроки, и у них есть общие очки и жизни.
     * Представим что все игроки это камикадзе и они должны умирать после того как заработают 1 очко.
     * Пока один игрок мертв, то другие могут увеличить очки.*/
    private void update() {
        synchronized (scoreLock) {
            if (lives == 0) {
                isGameOver = true;
                return;
            }
            score++;
            System.out.printf("Score: %s Lives: %s | Player: (%s)\n", score, lives, Thread.currentThread().getName());
        }

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

    private void gameOver() {
        System.out.println("Game over! | " + Thread.currentThread().getName());
    }
}
