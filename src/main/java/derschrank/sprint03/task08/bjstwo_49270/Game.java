package derschrank.sprint03.task08.bjstwo_49270;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    private static final int DEFAULT_LIVES = 10;

    private final AtomicInteger score = new AtomicInteger();
    private final AtomicInteger lives = new AtomicInteger();
    private AtomicBoolean isDead;

    public Game() {
        isDead = new AtomicBoolean(false);
        lives.set(DEFAULT_LIVES);
        System.out.println("Game began. You have life's points: " + lives);
    }

    public void update(boolean flagScore, boolean flagLives) {
        if (!isDead.get()) {
            if (flagScore) {
                incrementScore();
            }
            if (flagLives) {
                decrementLives();
            }
        }
    }

    private void incrementScore() {
        score.incrementAndGet();
        System.out.println("You received one game's point ");
    }

    private void decrementLives() {
        synchronized (lives) {
            int lives = this.lives.decrementAndGet();
            System.out.println("You lost one life's point. Rest: " + this.lives);
            if (lives <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.println("Game is over.");
        isDead.set(true);
    }

    public boolean isAlive() {
        return !isDead.get();
    }
}
