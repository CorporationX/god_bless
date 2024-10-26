package school.faang.broforce;

import lombok.Getter;

@Getter
public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean makePoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (makePoints) {
                score++;
                System.out.println("Score " + score);
            }
        }

        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                System.out.println("Lives " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game Over!");
        System.exit(0);
    }
}
