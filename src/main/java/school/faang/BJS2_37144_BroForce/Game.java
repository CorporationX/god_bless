package school.faang.BJS2_37144_BroForce;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Game {
    private static final int GAME_STEPS = 100;
    private static final int DEFAULT_LIVES_AMOUNT = 10;
    private static final int THREAD_POOL_SIZE = 4;
    private static final int AWAIT_TERMINATION = 10;

    private int score;
    private int lives;
    private final Object scoreLock;
    private final Object livesLock;
    private ExecutorService service;

    public Game() {
        lives = DEFAULT_LIVES_AMOUNT;
        scoreLock = new Object();
        livesLock = new Object();
        service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        lives = DEFAULT_LIVES_AMOUNT;
        for (int i = 0; i < GAME_STEPS; i++) {
            if (lives <= 0) {
                break;
            }
            boolean isGotScore = ThreadLocalRandom.current().nextBoolean();
            boolean isLostLife = ThreadLocalRandom.current().nextBoolean();
            service.submit(() -> update(isGotScore, isLostLife));
        }
        service.shutdown();
        try {
            if (service.awaitTermination(AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                log.info("The game ended correctly!");
            } else {
                log.warn("The game didn't end correctly on time! Force shutting down executor!");
            }
        } catch (InterruptedException e) {
            log.error("Main thread was interrupted while waiting for the game to finish!", e);
        }
    }

    private void update(boolean isGotScore, boolean isLostLife) {
        synchronized (scoreLock) {
            if (isGotScore) {
                log.info("The score has been increased by 1!");
                score++;
            }
        }
        synchronized (livesLock) {
            if (isLostLife && lives > 0) {
                log.info("The lives amount was decreased by 1!");
                lives--;
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        log.info("GAME OVER! Total score - {}!", score);
    }
}
