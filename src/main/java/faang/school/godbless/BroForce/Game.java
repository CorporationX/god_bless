package faang.school.godbless.BroForce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Time;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Game {
    private int score = 0;
    private final Lock scoreLock = new ReentrantLock();
    private int lives;
    private final Lock livesLock = new ReentrantLock();
    @Getter
    private volatile boolean gameOver = false;

    public Game(int lives) {
        this.lives = lives;
    }

    public static void main(String[] args) {
        Game game = new Game(20);

        Runnable gameUpdateTask = () -> {
            while (!game.isGameOver()) {
                game.update();
            }
        };

        Thread user1GameUpdateThread = new Thread(gameUpdateTask);
        Thread user2GameUpdateThread = new Thread(gameUpdateTask);
        Thread user4GameUpdateThread = new Thread(gameUpdateTask);
        Thread user3GameUpdateThread = new Thread(gameUpdateTask);

        user1GameUpdateThread.start();
        user2GameUpdateThread.start();
        user3GameUpdateThread.start();
        user4GameUpdateThread.start();

        try {
            user1GameUpdateThread.join();
            user3GameUpdateThread.join();
            user1GameUpdateThread.join();
            user4GameUpdateThread.join();
        } catch (InterruptedException e) {
            log.error("Thread was interrupted: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public void update() {
        try {
            synchronized (livesLock) {
                if (lives > 0) {
                    lives--;
                    log.info("Life lost. Lives remaining: {}", lives);
                }
            }
            if (lives == 0) {
                gameOver();
                return;
            }
            synchronized (livesLock) {
                score++;
                log.info("Score updated. Current score: {}", score);
            }
        } catch (RuntimeException e) {
            log.error("Update thread was interrupted: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private void gameOver() {
        synchronized (livesLock) {
            if (!gameOver) {
                synchronized (scoreLock) {
                    score++;
                    log.info("Final score updated");
                    log.info("Game over. Final score: {}", score);
                    gameOver = true;
                }
            }
            Thread.currentThread().interrupt();
        }
    }
}