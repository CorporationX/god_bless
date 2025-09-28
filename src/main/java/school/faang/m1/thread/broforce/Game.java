package school.faang.m1.thread.broforce;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;


public class Game {
    private int score;
    private int lives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private final Object stateLock = new Object();
    private final AtomicBoolean running = new AtomicBoolean(true);

    Game(int lives) {
        this.lives = lives;
    }

    public void update(boolean gainedPoint, boolean lostLife) throws InterruptedException {

        synchronized (stateLock) {
            while (!running.get()) {
                stateLock.wait();
            }
        }

        if (gainedPoint) {
            synchronized (scoreLock) {
                score++;
                System.out.println("[update] Scores updated, new score: " + score);
            }
        }

        if (lostLife) {
            synchronized (livesLock) {
                lives--;
                if (lives <= 0) {
                    System.out.println("[update] Glory to Odin! You returned to Valhalla!");
                    gameOver();
                } else {
                    System.out.println("[update] Glory to Odin! You returned from Valhalla with "
                            + lives + " lives left!");
                }
            }
        }
    }

    private void gameOver() {
        synchronized (stateLock) {
            if (running.compareAndSet(true, false)) {
                System.out.println("[gameOver] Final score: " + getScoreUnsafe());
                stateLock.notifyAll();
            }
        }
    }

    public boolean isRunning() {
        return running.get();
    }

    public int getScoreUnsafe() {
        synchronized (scoreLock) {
            return score;
        }
    }

    public int getLivesUnsafe() {
        synchronized (livesLock) {
            return lives;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(5);
        int workers = 6;
        Thread[] threads = new Thread[workers];
        Random rnd = new Random();

        for (int i = 0; i < workers; i++) {
            threads[i] = new Thread(() -> {
                try {
                    do {
                        boolean gainedPoint = rnd.nextInt(100) < 60; // 60% chance to score
                        boolean lostLife = rnd.nextInt(100) < 20; // 20% chance to lose a life

                        game.update(gainedPoint, lostLife);

                        if (rnd.nextInt(100) < 5) {
                            System.out.printf("[statistics:thread] %s -> score=%d, lives=%d%n",
                                    Thread.currentThread().getName(),
                                    game.getScoreUnsafe(), game.getLivesUnsafe());
                        }

                        Thread.sleep(10);

                    } while (game.isRunning());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "W-" + i);
            threads[i].start();
        }

        Thread.sleep(1500);

        System.out.printf("[statistics:total] score=%d, lives=%d, running=%s%n",
                game.getScoreUnsafe(), game.getLivesUnsafe(), game.isRunning());

        for (Thread t : threads) {
            t.join();
        }
        System.out.println("GAME OVER");
    }
}