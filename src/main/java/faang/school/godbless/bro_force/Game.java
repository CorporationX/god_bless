package faang.school.godbless.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    private int score;
    private int lives;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public Game () {
        this.score = 0;
        this.lives = 5;
    }

    public void update() {
        synchronized (lock1) {
            if(lives < 1) {
                gameOver();
            } else {
                lives--;
                System.out.println("Lives: " + lives);
            }
        }

        synchronized (lock1) {
            if(lives < 1) {
                gameOver();
            } else {
                score++;
                System.out.println("Score: " + score);
                System.out.println();
            }

        }
    }

    private void gameOver() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " YOU DIED");
        }

    }

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 10; i++) {
            executorService.execute(() -> game.update());
        }
    }
}
