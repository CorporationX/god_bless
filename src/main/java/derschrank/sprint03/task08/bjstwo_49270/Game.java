package derschrank.sprint03.task08.bjstwo_49270;

import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    private static final int DEFAULT_LIVES = 10;

    private final AtomicInteger score = new AtomicInteger();
    private final AtomicInteger lives = new AtomicInteger();
    private boolean isDead;

    public Game() {
        isDead = false;
        lives.set(DEFAULT_LIVES);
        System.out.println("Game began. You have life's points: " + lives);
    }

    public void update(boolean flagScoreOrLives) {
        if (!isDead) {
            if (flagScoreOrLives) {
                incrementScore();
            } else {
                decrementLives();
            }
        }
    }

    private void incrementScore() {
        synchronized (score) {
            score.incrementAndGet();
            System.out.println("You received one game's point ");
        }
    }

    private void decrementLives() {
        synchronized (lives) {
            int l = lives.decrementAndGet();
            System.out.println("You lost one life's point. Rest: " + lives);
            if (l <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.println("Game is over.");
        isDead = true;
    }

    public boolean isAlive() {
        return !isDead;
    }
}
