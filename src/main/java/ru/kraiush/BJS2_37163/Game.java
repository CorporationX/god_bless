package ru.kraiush.BJS2_37163;

public class Game {
    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public Game() {
        this.score = 0;
        this.lives = 5;
    }

    public void update(boolean isEarnScore, boolean isLiveLost) {
        synchronized (lockScore) {
            if (isEarnScore) {
                score++;
                System.out.println("You increased the game score ;) Score: " + score + ", Lives: " + lives);
            }
        }

        synchronized (lockLives) {
            if (isLiveLost) {
                lives--;
                System.out.println("You lost one life :( Score: " + score + ", Lives: " + lives);
            }
            if (lives == 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over!");
    }
}
