package school.faang.broforce;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object liveLock = new Object();
    private final AtomicBoolean isGameOver = new AtomicBoolean(false);
    private final Random random = new Random();

    public Game(int initialLives) {
        this.score = 0;
        this.lives = initialLives;
    }

    public synchronized void update() {
        if (isGameOver.get()) {
            return;
        }
        if (random.nextBoolean()) {
            score++;
            System.out.println("Score increased. Current score " + score);
        } else {
            lives--;
            System.out.println("Live is lost. Current lives " + lives);
            if (lives <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        if (isGameOver.compareAndSet(false, true)) {
            System.out.println("Game over! Final score: " + score);
        }
    }

    public boolean getIsGameOver() {
        return isGameOver.get();
    }

    public int getScore() {
        synchronized (scoreLock) {
            return score;
        }
    }

    public int getLives() {
        synchronized (liveLock) {
            return lives;
        }
    }
}
