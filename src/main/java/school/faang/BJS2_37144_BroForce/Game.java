package school.faang.BJS2_37144_BroForce;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Game {
    private static final int DEFAULT_LIVES_AMOUNT = 10;
    private static final int THREAD_POOL_SIZE = 4;
    private static final int UPDATE_RATE = 1;

    private int score;
    private int lives;
    private volatile boolean isGameOver;
    private final Object scoreLock;
    private final Object livesLock;
    private ScheduledExecutorService service;
    private CountDownLatch latch;

    public Game() {
        lives = DEFAULT_LIVES_AMOUNT;
        scoreLock = new Object();
        livesLock = new Object();
        service = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        latch = new CountDownLatch(1);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        isGameOver = false;
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            service.scheduleAtFixedRate(() -> {
                boolean isGotScore = ThreadLocalRandom.current().nextBoolean();
                boolean isLostLife = ThreadLocalRandom.current().nextBoolean();
                update(isGotScore, isLostLife);
            }, 0, UPDATE_RATE, TimeUnit.SECONDS);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            log.error("Main thread was interrupted while waiting", e);
        }
        service.shutdown();
    }

    private void update(boolean isGotScore, boolean isLostLife) {
        synchronized (scoreLock) {
            synchronized (livesLock) {
                if (isGameOver) {
                    return;
                }
                if (isGotScore) {
                    log.info("The score has been increased by 1!");
                    score++;
                }
                if (isLostLife) {
                    log.info("The lives amount was decreased by 1!");
                    lives--;
                }
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        synchronized (livesLock) {
            log.info("GAME OVER! Total score - {}!", score);
            isGameOver = true;
            score = 0;
            lives = DEFAULT_LIVES_AMOUNT;
            latch.countDown();
        }
    }
}
