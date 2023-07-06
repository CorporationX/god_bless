package faang.school.godbless.Multitrading2.BroForce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    private final Object lock = new Object();
    private final Object lock1 = new Object();
    private int score;
    private int lives;

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public static void main(String[] args) {
        Game game = new Game(0, 5);


        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> game.update(true));
            executor.execute(() -> game.update(false));
        }

        executor.shutdown();
    }

    public void update(boolean isWinner) {
        synchronized (lock) {
            if (isWinner && lives > 0) {
                score++;
                System.out.println(Thread.currentThread().getName() + " Score: " + score);
            } else if (lives <= 1) {
                synchronized (lock1) {
                    lives--;
                    gameOver();
                }
            } else {
                synchronized (lock1) {
                    lives--;
                    System.out.println(Thread.currentThread().getName() + " Lives: " + lives);
                }
            }
        }
    }

    private void gameOver() {
        System.out.println(Thread.currentThread().getName() + " Game Over");
    }
}
