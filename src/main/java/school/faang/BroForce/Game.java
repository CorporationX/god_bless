package school.faang.BroForce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private volatile int score;
    private volatile int lives;
    private volatile int scoreToWin;
    private volatile boolean gameOver = false;

    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public Game(int lives, int scoreToWin) {
        this.lives = lives;
        this.scoreToWin = scoreToWin;
        this.score = 0;
    }

    public void update(boolean scoreUpdated, boolean livesUpdated) {
        if (!gameOver) {
            if (scoreUpdated) {
                updateScore();
            }
            if (livesUpdated) {
                updateLives();
            }
        }
    }

    private void updateScore() {
        synchronized (lockScore) {
            if (!gameOver) {
                score++;
                System.out.println("Current score: " + score);
                if (score >= scoreToWin) {
                    gameOver();
                }
            }
        }
    }

    private synchronized void updateLives() {
        synchronized (lockLives) {
            if (!gameOver) {
                lives--;
                System.out.println("Lives left : " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    public void gameOver() {
        if (!gameOver) {
            if (lives <= 0) {
                System.out.println("Player lost!");
            } else {
                System.out.println("Player won!");
            }
            gameOver = true;
        }

    }
}
