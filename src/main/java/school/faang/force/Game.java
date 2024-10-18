package school.faang.force;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {
    private int score;
    private int lives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean scored, boolean lostLife) {
        synchronized (scoreLock) {
            if (scored) {
                score++;
                System.out.println("Очки: " + score);
            }
        }

        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                System.out.println("Жизни: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра окончена!");
    }
}
