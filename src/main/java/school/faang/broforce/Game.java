package school.faang.broforce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                score++;
                System.out.println("Score increased, current score: " + score);
            }
        }

        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                System.out.println("Lives decreased, remaining lives: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game Over! All lives are lost.");
    }
}

