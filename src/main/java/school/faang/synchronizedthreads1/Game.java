package school.faang.synchronizedthreads1;

import lombok.Data;

@Data
public class Game {

    private int score = 0;
    private int lives = 3;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean scoreIncrease, boolean lifeLost) {

        synchronized (scoreLock) {
            if (scoreIncrease) {
                score++;
                System.out.println("Score increased: " + score);
            }
        }

        synchronized (livesLock) {
            if (lifeLost) {
                lives--;
                System.out.println("Life lost: " + lives);


                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game Over! Final Score: " + score);

    }

}
