package bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Game {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();
    private int score;
    private int lives;

    public Game() {
        score = 0;
        lives = 10;
    }

    public void update() {
        synchronized (lock1) {
            if (lives <= 1) {
                lives--;
                gameOver();
            } else {
                score++;
                System.out.println(Thread.currentThread().getName() + " Score: " + score);
                lives--;
                System.out.println(Thread.currentThread().getName() + " Lives: " + lives);
            }
        }
    }

    public void gameOver() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " Game Over");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            executor.execute(game::update);
            executor.execute(game::update);
        }

        executor.shutdown();
    }
}
