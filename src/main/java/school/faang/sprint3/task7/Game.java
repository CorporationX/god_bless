package school.faang.sprint3.task7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Game {
    private int score;
    private int lives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public boolean update(boolean scoresUpdated, boolean lifeLost) {
        synchronized (scoreLock) {
            if (scoresUpdated) {
                score++;
                System.out.println("Scores: " + score);
            }
        }
        synchronized (livesLock) {
            if (lifeLost) {
                lives--;
                System.out.println("Lives: " + lives);
            }
            if (lives == 0) {
                if (gameOver()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean gameOver() {
        System.out.println("Game Over!");
        return true;
    }
}
