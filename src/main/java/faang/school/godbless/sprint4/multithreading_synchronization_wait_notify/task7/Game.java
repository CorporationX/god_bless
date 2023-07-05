package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {

    private int score;

    private int lives;

    private Object lock1 = new Object();

    private Object lock2 = new Object();

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
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
        System.out.println(Thread.currentThread().getName() + " Game Over");
    }

    public static void main(String[] args) {
        Game game = new Game(0, 5);

        Thread thread1 = new Thread(game::update);
        Thread thread2 = new Thread(game::update);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            executor.execute(thread1);
            executor.execute(thread2);
        }

        executor.shutdown();
    }
}
