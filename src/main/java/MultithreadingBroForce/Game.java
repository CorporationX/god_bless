package MultithreadingBroForce;

import lombok.Getter;

@Getter
public class Game {
    private Object scoreLock = new Object();
    private Object livesLock = new Object();
    private int score;
    private int lives;

    public void update(boolean scoresEarned, boolean livesLost) throws InterruptedException {
        synchronized(scoreLock) {
            if (scoresEarned) {
                score++;
                System.out.println("Earned scores! Your score is " + score);
            }
        }

        synchronized(livesLock) {
            if (livesLost) {
                lives--;
                System.out.println("Your life is " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over!");
        lives = 0;
        score = 0;
    }
}
