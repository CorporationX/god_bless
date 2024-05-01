package faang.school.godbless.broForce;

import lombok.Getter;

public class Game {
    private int score = 0;
    private int lives = 5;
    @Getter
    private boolean gameOver = false;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public int getScore() {
        synchronized (scoreLock) {
            return score;
        }
    }

    public void update() {
        synchronized (scoreLock) {
            score++;
        }
        synchronized (livesLock) {
            lives--;
            if (lives <= 0) {
                gameOver();
            }
        }
    }

    public void gameOver() {
        System.out.println("Game over!");
        gameOver = true;
    }

    public int getLives() {
        synchronized (livesLock) {
            return lives;
        }
    }


}
