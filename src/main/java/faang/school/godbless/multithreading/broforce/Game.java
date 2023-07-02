package faang.school.godbless.multithreading.broforce;

import lombok.Getter;

@Getter
public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game() {
        score = 0;
        lives = 100;
    }

    public void update() {
        synchronized (livesLock) {
            if (lives <= 0) { // При смерти персонажа никто не сможет изменить score.
                gameOver();
                return;
            } else {
                lives--;
                System.out.printf("Died! (%s)\n", Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("Reborn! (%s)\n", Thread.currentThread().getName());
            }
        }
        synchronized (scoreLock) {
            score++;
        }
        System.out.printf("Score: %s Lives: %s (%s)\n", score, lives, Thread.currentThread().getName());
    }

    private void gameOver() {
        System.out.println("Game over! | " + Thread.currentThread().getName());
    }
}
